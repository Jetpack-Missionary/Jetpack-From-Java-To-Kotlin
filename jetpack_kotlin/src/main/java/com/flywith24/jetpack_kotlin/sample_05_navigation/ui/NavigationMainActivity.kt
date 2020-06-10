package com.flywith24.jetpack_kotlin.sample_05_navigation.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.sample_05_navigation.ui.callback.SharedViewModel
import com.kunminx.architecture.kotlin.observeEvent
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   21:56
 * description
 */
class NavigationMainActivity : BaseActivity(R.layout.kotlin_activity_main_navigation) {
    private val mSharedViewModel by viewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSharedViewModel.closeActivity.observeEvent(this) {
            finish()
        }
    }

}