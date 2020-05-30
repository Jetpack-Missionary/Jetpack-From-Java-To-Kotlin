package com.example.jetpack_kotlin.sample_01_lifecycles.domain

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   12:23
 * description
 */
class LocationManager private constructor() : DefaultLifecycleObserver {


    companion object {
        private val sManager = LocationManager()
        fun newInstance(): LocationManager = sManager
    }

    override fun onResume(owner: LifecycleOwner) {
        //TODO 我是获取附近位置列表信息的后台定位服务，我耗电巨大，我随着页面的 onResume 开启了
    }

    override fun onPause(owner: LifecycleOwner) {
        //TODO 我随着页面的 onPause 而关闭了
    }
}