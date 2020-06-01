package com.flywith24.jetpack_kotlin.sample_04_databinding.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.flywith24.jetpack_kotlin.databinding.KotlinActivityListDatabindingBinding
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.adapter.DataBindingMomentAdapter
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state.ListViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:29
 * description
 */
class DataBindingListActivity : BaseActivity() {
    private val mListViewModel by viewModels<ListViewModel>()
    private val mAdapter by lazy { DataBindingMomentAdapter(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<KotlinActivityListDatabindingBinding>(this, R.layout.kotlin_activity_list_databinding)
        binding.lifecycleOwner = this
        binding.vm = mListViewModel
        binding.click = ClickProxy()
        binding.adapter = mAdapter.apply {
            setOnItemClickListener { item, _ ->
                val intent = Intent(this@DataBindingListActivity, DataBindingDetailActivity::class.java).putExtra(Configs.THIS_MOMENT, item)
                startActivity(intent)
            }
        }

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
}