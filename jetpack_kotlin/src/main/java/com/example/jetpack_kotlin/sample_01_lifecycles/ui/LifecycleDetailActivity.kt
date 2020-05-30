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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Glide.with(this).load(APIs.PIC_URL).into(findViewById(R.id.iv))

        findViewById<TextView>(R.id.tv_locate).setOnClickListener {
            startActivity(Intent(this, LifecycleLocationActivity::class.java))
        }
    }
}