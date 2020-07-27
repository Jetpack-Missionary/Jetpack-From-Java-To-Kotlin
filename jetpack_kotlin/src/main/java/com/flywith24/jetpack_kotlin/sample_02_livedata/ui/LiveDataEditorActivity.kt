package com.flywith24.jetpack_kotlin.sample_02_livedata.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.APIs
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.kunminx.architecture.ui.BaseActivity
import com.kunminx.architecture.utils.loadImage

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:31
 * description
 */
class LiveDataEditorActivity : BaseActivity(R.layout.kotlin_activity_livedata_editor) {
    /**
     * 不推荐使用 Kotlin Synthetics
     * 可以使用 ViewBinding 和 功能更强大的 DataBinding 来替换 findViewById
     *
     * 本示例尽量只演示单个组件的使用，因此没有使用 ViewBinding 或 DataBinding
     *
     * 详情参考 https://juejin.im/post/5e8ef0bc518825736b749705#heading-17
     */
    private lateinit var mImageView: ImageView
    private lateinit var mTvLocation: TextView
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mImageView = findViewById(R.id.iv)
        mTvLocation = findViewById(R.id.tv_locate)

        mToolbar = findViewById(R.id.toolbar)
        mToolbar.apply {
            setNavigationOnClickListener { finish() }
            inflateMenu(R.menu.editor_menu)
            setOnMenuItemClickListener { item ->
                if (item.itemId == R.id.menu_save) {
                    showLongToast(getString(R.string.liveData_save_tip))
                }
                return@setOnMenuItemClickListener true
            }
        }

        mImageView.loadImage(APIs.SCENE_URL)

        mTvLocation.setOnClickListener {

            /**
             * startActivityForResult API 已弃用，可以使用新的 ActivityResult API
             * 详情见 https://github.com/Flywith24/Flywith24-ActivityResultRequest
             */
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                val location = it.data?.getStringExtra(Configs.LOCATION_RESULT)
                mTvLocation.text = location
            }.launch(Intent(this, LiveDataLocationActivity::class.java))
        }
    }
}