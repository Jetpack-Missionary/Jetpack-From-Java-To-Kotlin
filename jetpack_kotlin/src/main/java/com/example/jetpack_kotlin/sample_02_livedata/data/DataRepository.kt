package com.example.jetpack_kotlin.sample_02_livedata.data

import androidx.lifecycle.MutableLiveData
import com.example.jetpack_kotlin.sample_01_lifecycles.data.APIs
import com.example.jetpack_kotlin.sample_02_livedata.data.bean.Moment

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:09
 * description
 */
class DataRepository private constructor() {

    fun requestList(liveData: MutableLiveData<List<Moment>>) {
        val list = listOf(
                Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                        "台北夜市一条街", APIs.PIC_URL, "Flywith24", APIs.PIC_URL),
                Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                        "台北夜市一条街", APIs.PIC_URL, "Flywith24", APIs.PIC_URL),
                Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                        "台北夜市一条街", APIs.PIC_URL, "Flywith24", APIs.PIC_URL),
                Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                        "台北夜市一条街", APIs.PIC_URL, "Flywith24", APIs.PIC_URL),
                Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                        "台北夜市一条街", APIs.PIC_URL, "Flywith24", APIs.PIC_URL),
                Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                        "台北夜市一条街", APIs.PIC_URL, "Flywith24", APIs.PIC_URL),
                Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                        "台北夜市一条街", APIs.PIC_URL, "Flywith24", APIs.PIC_URL),
                Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                        "台北夜市一条街", APIs.PIC_URL, "Flywith24", APIs.PIC_URL)

        )

        liveData.value = list
    }

    companion object {
        private val sRepository = DataRepository()
        fun getInstance() = sRepository
    }
}