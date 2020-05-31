package com.example.jetpack_kotlin.sample_04_databinding.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_kotlin.common_data.bean.Moment
import com.example.jetpack_kotlin.sample_03_viewmodel.domain.MomentRequest
import com.example.jetpack_kotlin.sample_03_viewmodel.domain.Request

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   22:03
 * description
 */
internal class ListViewModel : ViewModel(), Request.IMomentRequest {

    val list = MutableLiveData<List<Moment>>(emptyList())

    private val mMomentRequest by lazy { MomentRequest() }

    override fun getListMutableLiveData(): LiveData<List<Moment>> = mMomentRequest.getListMutableLiveData()

    override fun requestList() {
        mMomentRequest.requestList()
    }
}