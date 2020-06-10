package com.flywith24.jetpack_kotlin.sample_one_more_thing.ui.state

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * @author Flywith24
 * @date   2020/6/10
 * time   00:35
 * description
 */
class OneMoreThingViewModel : ViewModel() {
    val pageAssetPath = ObservableField("use_jetpack.html")
}