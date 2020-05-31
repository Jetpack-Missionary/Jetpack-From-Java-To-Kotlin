package com.example.jetpack_kotlin.sample_04_databinding.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_koltin.R
import com.example.jetpack_koltin.databinding.AdapterLocationDatabindingBinding
import com.example.jetpack_kotlin.common_data.bean.LocationBean
import com.example.jetpack_kotlin.common_ui.adapter.locationDiffCallback
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   22:56
 * description
 */
class DataBindingLocationAdapter(context: Context) : SimpleBindingAdapter<LocationBean, AdapterLocationDatabindingBinding>(context, R.layout.adapter_location_databinding, locationDiffCallback) {
    override fun onBindItem(binding: AdapterLocationDatabindingBinding?, item: LocationBean?, holder: RecyclerView.ViewHolder?) {
        binding?.bean = item
    }
}