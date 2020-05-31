package com.example.jetpack_kotlin.sample_04_databinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.jetpack_koltin.R
import com.example.jetpack_koltin.databinding.ActivityDetailDatabindingBinding
import com.example.jetpack_kotlin.common_data.Configs
import com.example.jetpack_kotlin.common_data.bean.Moment
import com.example.jetpack_kotlin.sample_04_databinding.state.DetailViewModel
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

        val binding = DataBindingUtil.setContentView<ActivityDetailDatabindingBinding>(this, R.layout.activity_detail_databinding)
        binding.lifecycleOwner = this
        binding.vm = mDetailViewModel

        val moment = intent.getParcelableExtra<Moment>(Configs.THIS_MOMENT)
        mDetailViewModel.initState(moment)
    }
}