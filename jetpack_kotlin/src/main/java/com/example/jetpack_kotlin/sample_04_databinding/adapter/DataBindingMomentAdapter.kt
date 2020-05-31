package com.example.jetpack_kotlin.sample_04_databinding.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_koltin.R
import com.example.jetpack_koltin.databinding.AdapterMomentDatabindingBinding
import com.example.jetpack_kotlin.common_data.bean.Moment
import com.example.jetpack_kotlin.common_ui.adapter.momentDiffCallback
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   22:56
 * description
 */
class DataBindingMomentAdapter(context: Context) : SimpleBindingAdapter<Moment, AdapterMomentDatabindingBinding>(context, R.layout.adapter_moment_databinding, momentDiffCallback) {
    override fun onBindItem(binding: AdapterMomentDatabindingBinding?, item: Moment?, holder: RecyclerView.ViewHolder?) {
        binding?.bean = item
    }
}