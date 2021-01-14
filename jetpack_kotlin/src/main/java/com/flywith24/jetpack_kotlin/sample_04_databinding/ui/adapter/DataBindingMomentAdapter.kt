package com.flywith24.jetpack_kotlin.sample_04_databinding.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.flywith24.jetpack_kotlin.common_ui.adapter.MomentDiffCallback
import com.flywith24.jetpack_kotlin.databinding.KotlinAdapterMomentDatabindingBinding
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   22:56
 * description
 */
class DataBindingMomentAdapter(context: Context) : SimpleBindingAdapter<Moment, KotlinAdapterMomentDatabindingBinding>(context, R.layout.kotlin_adapter_moment_databinding, MomentDiffCallback) {
    override fun onBindItem(binding: KotlinAdapterMomentDatabindingBinding?, item: Moment?, holder: RecyclerView.ViewHolder?) {
        binding?.moment = item
    }
}