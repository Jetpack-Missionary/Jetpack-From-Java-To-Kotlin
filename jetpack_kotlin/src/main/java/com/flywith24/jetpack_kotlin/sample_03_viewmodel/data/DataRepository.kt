package com.flywith24.jetpack_kotlin.sample_03_viewmodel.data

import androidx.lifecycle.MutableLiveData
import com.flywith24.jetpack_kotlin.common_data.APIs
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import java.util.*

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   22:03
 * description
 */
internal class DataRepository private constructor() {

    fun requestList(liveData: MutableLiveData<List<Moment>>) {
        val list = listOf(
                Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                        "重庆朝天门码头", APIs.SCENE_URL, "KunMinX", APIs.KUNMINX_URL),
                Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                        "重庆朝天门码头", APIs.SCENE_URL, "Flywith24", APIs.FLYWITH24_URL),
                Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                        "重庆朝天门码头", APIs.SCENE_URL, "KunMinX", APIs.KUNMINX_URL),
                Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                        "重庆朝天门码头", APIs.SCENE_URL, "Flywith24", APIs.FLYWITH24_URL),
                Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                        "重庆朝天门码头", APIs.SCENE_URL, "KunMinX", APIs.KUNMINX_URL),
                Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                        "重庆朝天门码头", APIs.SCENE_URL, "Flywith24", APIs.FLYWITH24_URL),
                Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                        "重庆朝天门码头", APIs.SCENE_URL, "KunMinX", APIs.KUNMINX_URL),
                Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                        "重庆朝天门码头", APIs.SCENE_URL, "Flywith24", APIs.FLYWITH24_URL)

        )

        liveData.value = list

    }

    private fun getUUID(): String = UUID.randomUUID().toString().replace("-", "")

    companion object {
        private val sRepository = DataRepository()
        fun getInstance(): DataRepository = sRepository
    }
}