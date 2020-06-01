package com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.flywith24.jetpack_kotlin.common_data.bean.Moment

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:11
 * description
 */
class DetailViewModel : ViewModel() {
    val imgUrl = ObservableField<String>()
    val name = ObservableField<String>()
    val content = ObservableField<String>()
    val location = ObservableField<String>()
    val avatar = ObservableField<String>()

    fun initState(moment: Moment) {
        avatar.set(moment.userAvatar)
        name.set(moment.username)
        content.set(moment.content)
        imgUrl.set(moment.imgUrl)
        location.set(moment.location)
    }
}