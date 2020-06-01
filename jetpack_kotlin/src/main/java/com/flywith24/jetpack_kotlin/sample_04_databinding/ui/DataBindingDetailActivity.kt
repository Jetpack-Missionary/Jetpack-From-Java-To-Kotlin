package com.flywith24.jetpack_kotlin.sample_04_databinding.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.flywith24.jetpack_kotlin.databinding.KotlinActivityDetailDatabindingBinding
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state.DetailViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:30
 * description
 */
class DataBindingDetailActivity : BaseActivity() {
    private val mDetailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<KotlinActivityDetailDatabindingBinding>(this, R.layout.kotlin_activity_detail_databinding)
        binding.lifecycleOwner = this
        binding.vm = mDetailViewModel

        val moment = intent.getParcelableExtra<Moment>(Configs.THIS_MOMENT)
        moment?.let {
            mDetailViewModel.initState(it)
        }
    }
}