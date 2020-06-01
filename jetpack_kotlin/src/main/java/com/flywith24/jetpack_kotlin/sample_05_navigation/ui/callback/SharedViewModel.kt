package com.flywith24.jetpack_kotlin.sample_05_navigation.ui.callback

import androidx.lifecycle.ViewModel
import com.kunminx.architecture.bridge.callback.UnPeekLiveData

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   21:54
 * description
 */
class SharedViewModel : ViewModel() {
    val location = UnPeekLiveData<String>()

}