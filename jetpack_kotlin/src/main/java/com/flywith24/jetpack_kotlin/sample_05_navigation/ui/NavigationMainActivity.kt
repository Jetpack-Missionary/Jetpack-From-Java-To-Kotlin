package com.flywith24.jetpack_kotlin.sample_05_navigation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.databinding.KotlinActivityMainNavigationBinding
import com.flywith24.jetpack_kotlin.sample_05_navigation.ui.state.MainViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   21:56
 * description
 */
class NavigationMainActivity : BaseActivity() {
    private val mMainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("yyz11", "NavigationMainActivity")
        val binding = DataBindingUtil.setContentView<KotlinActivityMainNavigationBinding>(this, R.layout.kotlin_activity_main_navigation)
    }
}