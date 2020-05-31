package com.example.jetpack_kotlin.sample_01_lifecycles.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_koltin.R
import com.example.jetpack_kotlin.common_data.Configs
import com.example.jetpack_kotlin.common_data.bean.LocationBean
import com.example.jetpack_kotlin.common_ui.adapter.LocationAdapter
import com.example.jetpack_kotlin.sample_01_lifecycles.domain.LifecycleLocationManager
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   11:20
 * description
 */
class LifecycleLocationActivity : BaseActivity(R.layout.activity_lifecycles_location), LocationAdapter.OnItemClickListener {
    /**
     * 不推荐使用 Kotlin Synthetics
     * 可以使用 ViewBinding 和 功能更强大的 DataBinding 来替换 findViewById
     *
     * 本示例尽量只演示单个组件的使用，因此没有使用 ViewBinding 或 DataBinding
     *
     * 详情参考 https://juejin.im/post/5e8ef0bc518825736b749705#heading-17
     */
    private lateinit var mRecyclerView: RecyclerView
    private val mAdapter by lazy { LocationAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRecyclerView = findViewById(R.id.rv)
        mRecyclerView.adapter = mAdapter

        lifecycle.addObserver(LifecycleLocationManager.newInstance())

        LifecycleLocationManager.newInstance().setILocationCallback { list ->
            runOnUiThread {
                mAdapter.submitList(list)
            }
        }
    }

    override fun onItemClick(locationBean: LocationBean) {
        setResult(Activity.RESULT_OK, Intent().putExtra(Configs.LOCATION_RESULT, locationBean.locationName))
        finish()
    }
}