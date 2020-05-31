package com.example.jetpack_kotlin.sample_04_databinding.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_kotlin.common_data.bean.LocationBean

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:13
 * description
 */
class LocationViewModel : ViewModel() {
    val list = MutableLiveData<List<LocationBean>>()
}