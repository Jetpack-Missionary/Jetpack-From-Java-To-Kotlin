package com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.flywith24.jetpack_kotlin.common_data.APIs

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:11
 * description
 */
class EditorViewModel : ViewModel() {
    val imgUrl = ObservableField(APIs.ADD_PIC_TIP_URL)
    val content = ObservableField("")
    val location = ObservableField("点击添加定位")

}