package com.example.jetpack_kotlin.sample_04_databinding

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.example.jetpack_koltin.R
import com.example.jetpack_koltin.databinding.ActivityListDatabindingBinding
import com.example.jetpack_kotlin.sample_04_databinding.state.ListViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:29
 * description
 */
class DataBindingListActivity : BaseActivity() {
    private val mListViewModel by viewModels<ListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityListDatabindingBinding>(this, R.layout.activity_list_databinding)
        binding.lifecycleOwner = this
        binding.vm = mListViewModel
        binding.click = ClickProxy()

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