package com.example.jetpack_kotlin.sample_03_viewmodel.domain

import androidx.lifecycle.LiveData
import com.example.jetpack_kotlin.common_data.bean.Moment

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   22:10
 * description
 */
internal class Request {
    interface IMomentRequest {

        fun getListMutableLiveData(): LiveData<List<Moment>>

        fun requestList()
    }
}