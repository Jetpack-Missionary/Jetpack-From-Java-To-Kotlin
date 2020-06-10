package com.flywith24.jetpack_kotlin.sample_one_more_thing.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.databinding.KotlinActivityOneMoreThingBinding
import com.flywith24.jetpack_kotlin.sample_one_more_thing.ui.state.OneMoreThingViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/6/10
 * time   00:31
 * description
 */
class OneMoreThingActivity : BaseActivity() {

    /**
     * activity 级别共享 ViewModel
     *
     * activity-ktx 扩展函数
     *
     * ViewModel 如何控制作用域，请参考
     * https://juejin.im/post/5e786d415188255e00661a4e#heading-10
     */
    private val mOneMoreThingViewModel by viewModels<OneMoreThingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(DataBindingUtil.setContentView<KotlinActivityOneMoreThingBinding>(this, R.layout.kotlin_activity_one_more_thing)) {
            lifecycleOwner = this@OneMoreThingActivity
            vm = mOneMoreThingViewModel
            click = ClickProxy()
        }
    }

    inner class ClickProxy {
        fun back() {
            finish()
        }
    }
}