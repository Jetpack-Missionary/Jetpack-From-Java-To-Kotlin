package com.flywith24.jetpack_kotlin.sample_02_livedata.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

import androidx.recyclerview.widget.RecyclerView
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.flywith24.jetpack_kotlin.common_data.bean.LocationBean
import com.flywith24.jetpack_kotlin.common_ui.adapter.LocationAdapter
import com.flywith24.jetpack_kotlin.sample_02_livedata.domain.LiveDataLocationManager
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:31
 * description
 */
class LiveDataLocationActivity : BaseActivity(R.layout.kotlin_activity_livedata_list) {
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

    private val mAdapter: LocationAdapter by lazy { LocationAdapter { adapterClick(it) } }

    private fun adapterClick(locationBean: LocationBean) {
        setResult(Activity.RESULT_OK, Intent().putExtra(Configs.LOCATION_RESULT, locationBean.locationName))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mToolbar = findViewById(R.id.toolbar)
        mToolbar.setNavigationOnClickListener { finish() }

        mRecyclerView = findViewById(R.id.rv)
        mRecyclerView.adapter = mAdapter

        lifecycle.addObserver(LiveDataLocationManager.getInstance())

        LiveDataLocationManager.getInstance().getLocationBeans().observe(this) { list ->
            mAdapter.submitList(list)
        }
    }
}