package com.kunminx.architecture

import android.app.Application

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:43
 * description
 */
open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        @JvmStatic
        lateinit var instance: Application
    }
}