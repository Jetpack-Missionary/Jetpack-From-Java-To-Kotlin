package com.flywith24.jetpack_kotlin.sample_02_livedata.domain

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
class LiveDataLocationManager private constructor() : DefaultLifecycleObserver {
    private var mTimer: Timer? = null
    private val mLocationBeans = MutableLiveData<List<LocationBean>>()

    fun getLocationBeans(): LiveData<List<LocationBean>> = mLocationBeans

    private val mList = ArrayList<LocationBean>()

    override fun onResume(owner: LifecycleOwner) {
        //TODO 我是获取附近位置列表信息的后台定位服务，我耗电巨大，我随着页面的 onResume 开启了

        mTimer = Timer()

        val task = timerTask {
            //模拟定位，假设开启了 GPS 并且每秒获取若干条新的位置信息

            mList.add(LocationBean("台北夜市 ${System.currentTimeMillis()} 号"))
            mLocationBeans.postValue(mList)
            onResume(owner)
        }

        mTimer?.schedule(task, 250)
    }

    override fun onPause(owner: LifecycleOwner) {
        //TODO 我随着页面的 onPause 而关闭了

        mTimer?.cancel()
        mTimer = null

        mList.clear()
    }

    companion object {
        private val sManager = LiveDataLocationManager()
        fun getInstance(): LiveDataLocationManager = sManager
    }
}