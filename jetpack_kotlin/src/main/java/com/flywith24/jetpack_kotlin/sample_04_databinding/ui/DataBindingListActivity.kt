package com.flywith24.jetpack_kotlin.sample_04_databinding.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
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
    /**
     * activity-ktx 扩展函数
     */
    private val mListViewModel by viewModels<ListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<KotlinActivityListDatabindingBinding>(this, R.layout.kotlin_activity_list_databinding)
        binding.lifecycleOwner = this
        binding.vm = mListViewModel
        binding.click = ClickProxy()
        binding.adapter = DataBindingMomentAdapter(applicationContext).apply {
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        /**
         * onActivityResult API 已弃用，可以使用新的 ActivityResult API
         * 详情见 https://developer.android.com/training/basics/intents/result
         */
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            Configs.REQUEST_NEW_MOMENT -> {
                val moment = data?.getParcelableExtra<Moment>(Configs.NEW_MOMENT)
                mListViewModel.list.value?.let { list ->
                    mListViewModel.list.value = ArrayList(list).apply { add(0, moment) }
                }
            }
        }
    }

    inner class ClickProxy {
        fun fabClick() {
            /**
             * startActivityForResult API 已弃用，可以使用新的 ActivityResult API
             * 详情见 https://developer.android.com/training/basics/intents/result
             */
            startActivityForResult(
                    Intent(this@DataBindingListActivity, DataBindingEditorActivity::class.java),
                    Configs.REQUEST_NEW_MOMENT)
        }

        fun back() {
            finish()
        }
    }
}