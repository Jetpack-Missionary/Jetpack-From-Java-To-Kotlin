package com.example.jetpack_kotlin.sample_02_livedata.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.jetpack_kotlin.sample_02_livedata.data.DataRepository
import com.example.jetpack_kotlin.sample_02_livedata.data.bean.Moment

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:16
 * description
 */
class MomentRequest {
    private val _listMutableLiveData by lazy { MutableLiveData<List<Moment>>() }

    //此处使用了 liveData ktx 库中的扩展函数：Transformations.map
    val listMutableLiveData: LiveData<List<Moment>> = _listMutableLiveData.map { it }

    fun requestList() {
        DataRepository.getInstance().requestList(_listMutableLiveData)
    }
}