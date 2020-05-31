package com.example.jetpack_kotlin.sample_04_databinding.state

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:11
 * description
 */
class EditorViewModel : ViewModel() {
    val imgUrl = ObservableField<String>()
    val content = ObservableField<String>()
    val location = ObservableField<String>("点击添加定位")

}