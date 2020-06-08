package com.flywith24.jetpack_kotlin.sample_04_databinding.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.APIs
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.flywith24.jetpack_kotlin.databinding.KotlinActivityEditorDatabindingBinding
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state.EditorViewModel
import com.kunminx.architecture.ui.BaseActivity
import java.util.*

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

        val binding = DataBindingUtil.setContentView<KotlinActivityEditorDatabindingBinding>(this, R.layout.kotlin_activity_editor_databinding)
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

    inner class ClickProxy : Toolbar.OnMenuItemClickListener {
        fun locate() {
            startActivityForResult(Intent(this@DataBindingEditorActivity, DataBindingLocationActivity::class.java),
                    Configs.REQUEST_LOCATION_INFO)
        }

        fun addPic() {
            mEditorViewModel.imgUrl.set(APIs.PIC_URL)
        }

        fun back() {
            finish()
        }

        override fun onMenuItemClick(item: MenuItem?): Boolean {
            if (item?.itemId == R.id.menu_save) {
                val moment = Moment(UUID.randomUUID().toString(),
                        mEditorViewModel.content.get(),
                        mEditorViewModel.location.get(),
                        mEditorViewModel.imgUrl.get() ?: "",
                        "Flywith24",
                        APIs.PIC_URL
                )
                setResult(Configs.REQUEST_NEW_MOMENT, Intent().putExtra(Configs.NEW_MOMENT, moment))
                finish()
            }
            return true
        }

    }
}