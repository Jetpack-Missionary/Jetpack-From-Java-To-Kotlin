package com.flywith24.jetpack_kotlin.sample_04_databinding.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
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
    /**
     * activity 级别共享 ViewModel
     *
     * activity-ktx 扩展函数
     *
     * ViewModel 如何控制作用域，请参考
     * https://juejin.im/post/5e786d415188255e00661a4e#heading-10
     */
    private val mEditorViewModel by viewModels<EditorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<KotlinActivityEditorDatabindingBinding>(this, R.layout.kotlin_activity_editor_databinding)
        binding.lifecycleOwner = this
        binding.vm = mEditorViewModel
        binding.click = ClickProxy()
    }


    inner class ClickProxy : Toolbar.OnMenuItemClickListener {
        fun locate() {
            /**
             * startActivityForResult API 已弃用，可以使用新的 ActivityResult API
             * 详情见 https://github.com/Flywith24/Flywith24-ActivityResultRequest
             */
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                val location = it.data?.getStringExtra(Configs.LOCATION_RESULT)
                mEditorViewModel.location.set(location)
            }.launch(Intent(this@DataBindingEditorActivity, DataBindingLocationActivity::class.java))
        }

        fun addPic() {
            mEditorViewModel.imgUrl.set(APIs.SCENE_URL)
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
                        APIs.FLYWITH24_URL
                )
                setResult(Configs.REQUEST_NEW_MOMENT, Intent().putExtra(Configs.NEW_MOMENT, moment))
                finish()
            }
            return true
        }

    }
}