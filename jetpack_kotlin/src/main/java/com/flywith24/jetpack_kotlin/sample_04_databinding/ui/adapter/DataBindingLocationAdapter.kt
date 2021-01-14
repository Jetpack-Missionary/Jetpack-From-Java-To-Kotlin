package com.flywith24.jetpack_kotlin.sample_04_databinding.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.bean.LocationBean
import com.flywith24.jetpack_kotlin.common_ui.adapter.LocationDiffCallback
import com.flywith24.jetpack_kotlin.databinding.KotlinAdapterLocationDatabindingBinding
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   22:56
 * description
 */
class DataBindingLocationAdapter(context: Context) : SimpleBindingAdapter<LocationBean, KotlinAdapterLocationDatabindingBinding>(context, R.layout.kotlin_adapter_location_databinding, LocationDiffCallback) {
    override fun onBindItem(binding: KotlinAdapterLocationDatabindingBinding?, item: LocationBean?, holder: RecyclerView.ViewHolder?) {
        binding?.bean = item
    }
}