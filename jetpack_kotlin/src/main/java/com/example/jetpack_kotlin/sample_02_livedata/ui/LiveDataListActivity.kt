package com.example.jetpack_kotlin.sample_02_livedata.ui

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_koltin.R
import com.example.jetpack_kotlin.sample_01_lifecycles.data.Configs
import com.example.jetpack_kotlin.sample_02_livedata.data.bean.Moment
import com.example.jetpack_kotlin.sample_02_livedata.domain.MomentRequest
import com.example.jetpack_kotlin.sample_02_livedata.ui.adapter.MomentAdapter
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:31
 * description
 */
class LiveDataListActivity : BaseActivity(R.layout.activity_livedata_list), MomentAdapter.OnItemClickListener {
    /**
     * 不推荐使用 Kotlin Synthetics
     * 可以使用 ViewBinding 和 功能更强大的 DataBinding 来替换 findViewById
     *
     * 本示例尽量只演示单个组件的使用，因此没有使用 ViewBinding 或 DataBinding
     *
     * 详情参考 https://juejin.im/post/5e8ef0bc518825736b749705#heading-17
     */
    private lateinit var mRecyclerView: RecyclerView
    private val mAdapter by lazy { MomentAdapter(this) }
    private val mMomentRequest by lazy { MomentRequest() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mRecyclerView = findViewById(R.id.rv)
        mRecyclerView.adapter = mAdapter

        mMomentRequest.listMutableLiveData.observe(this, Observer { list ->
            mAdapter.submitList(list)
        })
        mMomentRequest.requestList()
    }

    override fun onItemClick(moment: Moment) {
        startActivity(Intent(this, LiveDataDetailActivity::class.java).putExtra(Configs.THIS_MOMENT, moment))
    }
}