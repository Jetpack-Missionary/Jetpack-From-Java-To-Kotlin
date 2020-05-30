package com.example.jetpack_kotlin.sample_01_lifecycles.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.jetpack_koltin.R
import com.example.jetpack_kotlin.sample_01_lifecycles.data.APIs
import com.example.jetpack_kotlin.sample_01_lifecycles.data.Configs
import com.kunminx.architecture.ui.BaseActivity
import com.kunminx.architecture.utils.loadImage

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   11:39
 * description
 */
class LifecycleDetailActivity : BaseActivity(R.layout.activity_lifecycles_detail) {
    /**
     * 不推荐使用 Kotlin Synthetics
     * 可以使用 ViewBinding 和 功能更强大的 DataBinding 来替换 findViewById
     *
     * 本示例尽量只演示单个组件的使用，因此没有使用 ViewBinding 或 DataBinding
     *
     * 详情参考 https://juejin.im/post/5e8ef0bc518825736b749705#heading-17
     */
    private lateinit var mTvLocation: TextView
    private lateinit var mImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mTvLocation = findViewById(R.id.tv_locate)
        mImageView = findViewById(R.id.iv)

        mImageView.loadImage(APIs.PIC_URL)

        mTvLocation.setOnClickListener {
            startActivityForResult(Intent(this, LifecycleLocationActivity::class.java), Configs.REQUEST_LOCATION_INFO)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            Configs.REQUEST_LOCATION_INFO -> {
                val location = data?.getStringExtra(Configs.LOCATION_RESULT)
                mTvLocation.text = location
            }
        }
    }
}