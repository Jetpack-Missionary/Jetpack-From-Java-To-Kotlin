package com.flywith24.jetpack_kotlin.sample_03_viewmodel.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.flywith24.jetpack_kotlin.common_ui.adapter.MomentAdapter
import com.flywith24.jetpack_kotlin.sample_03_viewmodel.ui.state.ListViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   22:02
 * description
 */
class ViewModelListActivity : BaseActivity(R.layout.kotlin_activity_list_viewmodel) {

    /**
     * activity 级别共享 ViewModel
     *
     * activity-ktx 扩展函数
     *
     * ViewModel 如何控制作用域，请参考
     * https://juejin.im/post/5e786d415188255e00661a4e#heading-10
     */
    private val mListViewModel by viewModels<ListViewModel>()

    /**
     * 不推荐使用 Kotlin Synthetics
     * 可以使用 ViewBinding 和 功能更强大的 DataBinding 来替换 findViewById
     *
     * 本示例尽量只演示单个组件的使用，因此没有使用 ViewBinding 或 DataBinding
     *
     * 详情参考 https://juejin.im/post/5e8ef0bc518825736b749705#heading-17
     */
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mToolbar: Toolbar

    private val mAdapter by lazy { MomentAdapter { adapterClick(it) } }

    private fun adapterClick(moment: Moment) {
        showLongToast(getString(R.string.viewmodel_item_click_tip))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mToolbar = findViewById(R.id.toolbar)
        mToolbar.setNavigationOnClickListener { finish() }

        mRecyclerView = findViewById(R.id.rv)

        mRecyclerView.adapter = mAdapter

        mListViewModel.getListMutableLiveData().observe(this) { list ->
            mAdapter.submitList(list)
        }

        mListViewModel.requestList()
    }
}