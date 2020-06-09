package com.flywith24.jetpack_kotlin.sample_05_navigation.ui

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<KotlinActivityMainNavigationBinding>(this, R.layout.kotlin_activity_main_navigation)
    }
}