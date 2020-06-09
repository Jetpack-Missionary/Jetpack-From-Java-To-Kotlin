package com.flywith24.jetpack_kotlin.sample_one_more_thing.ui

import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/6/10
 * time   00:31
 * description
 */
class OneMoreThingActivity : BaseActivity() {

    inner class ClickProxy {
        fun back() {
            finish()
        }
    }
}