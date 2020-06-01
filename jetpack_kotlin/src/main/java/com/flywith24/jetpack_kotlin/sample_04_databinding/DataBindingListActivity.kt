package com.flywith24.jetpack_kotlin.sample_04_databinding

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.flywith24.jetpack_kotlin.common_ui.adapter.MomentAdapter
import com.flywith24.jetpack_kotlin.databinding.KotlinActivityListDatabindingBinding
import com.flywith24.jetpack_kotlin.sample_04_databinding.state.ListViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:29
 * description
 */
class DataBindingListActivity : BaseActivity(), MomentAdapter.OnItemClickListener {
    private val mListViewModel by viewModels<ListViewModel>()
    private val mAdapter by lazy { MomentAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<KotlinActivityListDatabindingBinding>(this, R.layout.kotlin_activity_list_databinding)
        binding.lifecycleOwner = this
        binding.vm = mListViewModel
        binding.click = ClickProxy()
        binding.adapter = mAdapter

        mListViewModel.getListMutableLiveData().observe(this) { moments ->
            mListViewModel.list.value = moments
        }

        mListViewModel.requestList()
    }

    inner class ClickProxy {
        fun fabClick() {
            startActivity(Intent(this@DataBindingListActivity, DataBindingEditorActivity::class.java))
        }
    }

    override fun onItemClick(moment: Moment) {

    }
}