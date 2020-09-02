package com.flywith24.jetpack_kotlin.sample_04_databinding.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

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
     * activity 级别共享 ViewModel
     *
     * activity-ktx 扩展函数
     *
     * ViewModel 如何控制作用域，请参考
     * https://juejin.im/post/5e786d415188255e00661a4e#heading-10
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

    inner class ClickProxy {
        fun fabClick() {
            /**
             * startActivityForResult API 已弃用，可以使用新的 ActivityResult API
             * 详情见 https://github.com/Flywith24/Flywith24-ActivityResultRequest
             */
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                val moment = it.data?.getParcelableExtra<Moment>(Configs.NEW_MOMENT)
                mListViewModel.list.value?.let { list ->
                    mListViewModel.list.value = ArrayList(list).apply { add(0, moment) }
                }
            }.launch(Intent(this@DataBindingListActivity, DataBindingEditorActivity::class.java))
        }

        fun back() {
            finish()
        }
    }
}