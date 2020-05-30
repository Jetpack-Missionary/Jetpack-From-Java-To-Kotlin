package com.example.jetpack_kotlin.sample_01_lifecycles.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.jetpack_koltin.R
import com.example.jetpack_kotlin.sample_01_lifecycles.data.APIs
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   11:39
 * description
 */
class LifecycleDetailActivity : BaseActivity(R.layout.layout_activity_detail) {
    /**
     * 不推荐使用 Kotlin Synthetics
     * 可以使用 ViewBinding 和 功能更强大的 DataBinding 来替换 findViewById
     *
     * 本示例尽量只演示单个组件的使用，因此没有使用 ViewBinding 或 DataBinding
     *
     * 详情参考 https://juejin.im/post/5e8ef0bc518825736b749705#heading-17
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Glide.with(this).load(APIs.PIC_URL).into(findViewById(R.id.iv))

        findViewById<TextView>(R.id.tv_locate).setOnClickListener {
            startActivity(Intent(this, LifecycleLocationActivity::class.java))
        }
    }
}