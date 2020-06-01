package com.flywith24.jetpack_kotlin.sample_01_lifecycles.domain

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.flywith24.jetpack_kotlin.common_data.bean.LocationBean
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   12:23
 * description
 */
class LifecycleLocationManager private constructor() : DefaultLifecycleObserver {
    private var mTimer: Timer? = null
    private var mLocationBeans = ArrayList<LocationBean>()

    private var mILocationCallback: ILocationCallback? = null

    fun setILocationCallback(callback: ((List<LocationBean>) -> Unit)?) {
        mILocationCallback = object : ILocationCallback {
            override fun onListChanged(list: List<LocationBean>) {
                callback?.invoke(list)
            }
        }
    }

    override fun onResume(owner: LifecycleOwner) {
        //TODO 我是获取附近位置列表信息的后台定位服务，我耗电巨大，我随着页面的 onResume 开启了
        mTimer = Timer()
        val task = timerTask {
            //模拟定位，假设开启了 GPS 并且每秒获取若干条新的位置信息

            mLocationBeans.add(LocationBean("台北夜市 ${System.currentTimeMillis()} 号"))

            mILocationCallback?.onListChanged(mLocationBeans)
            onResume(owner)
        }

        mTimer?.schedule(task, 250)
    }

    override fun onPause(owner: LifecycleOwner) {
        //TODO 我随着页面的 onPause 而关闭了

        mTimer?.cancel()
        mTimer = null

        mLocationBeans.clear()
    }

    companion object {
        private val sManager = LifecycleLocationManager()
        fun getInstance(): LifecycleLocationManager = sManager
    }

    interface ILocationCallback {
        fun onListChanged(list: List<LocationBean>)
    }
}