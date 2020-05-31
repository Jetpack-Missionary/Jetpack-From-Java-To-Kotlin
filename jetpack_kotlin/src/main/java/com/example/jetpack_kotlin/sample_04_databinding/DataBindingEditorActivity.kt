package com.example.jetpack_kotlin.sample_04_databinding

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.jetpack_koltin.R
import com.example.jetpack_koltin.databinding.ActivityEditorDatabindingBinding
import com.example.jetpack_kotlin.common_data.Configs
import com.example.jetpack_kotlin.sample_04_databinding.state.EditorViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:30
 * description
 */
class DataBindingEditorActivity : BaseActivity() {
    private val mEditorViewModel by viewModels<EditorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityEditorDatabindingBinding>(this, R.layout.activity_editor_databinding)
        binding.lifecycleOwner = this
        binding.vm = mEditorViewModel
        binding.click = ClickProxy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            Configs.REQUEST_LOCATION_INFO -> {
                val location = data?.getStringExtra(Configs.LOCATION_RESULT)
                mEditorViewModel.location.set(location)
            }
        }
    }

    inner class ClickProxy {
        fun locate() {
            startActivityForResult(Intent(this@DataBindingEditorActivity, DataBindingLocationActivity::class.java),
                    Configs.REQUEST_LOCATION_INFO)
        }
    }
}