package com.flywith24.jetpack_kotlin.sample_04_databinding.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.flywith24.jetpack_kotlin.databinding.KotlinActivityLocationDatabindingBinding
import com.flywith24.jetpack_kotlin.sample_02_livedata.domain.LiveDataLocationManager
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.adapter.DataBindingLocationAdapter
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state.LocationViewModel
import com.kunminx.architecture.ui.BaseActivity

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:14
 * description
 */
class DataBindingLocationActivity : BaseActivity() {
    /**
     * activity 级别共享 ViewModel
     *
     * activity-ktx 扩展函数
     *
     * ViewModel 如何控制作用域，请参考
     * https://juejin.im/post/5e786d415188255e00661a4e#heading-10
     */
    private val mLocationViewModel by viewModels<LocationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<KotlinActivityLocationDatabindingBinding>(this, R.layout.kotlin_activity_location_databinding)
        binding.lifecycleOwner = this
        binding.vm = mLocationViewModel
        binding.click = ClickProxy()
        binding.adapter = DataBindingLocationAdapter(applicationContext).apply {
            setOnItemClickListener { item, _ ->
                setResult(Activity.RESULT_OK,
                        Intent().putExtra(Configs.LOCATION_RESULT, item.locationName))
                finish()
            }
        }

        lifecycle.addObserver(LiveDataLocationManager.getInstance())

        LiveDataLocationManager.getInstance().getLocationBeans().observe(this) { list ->
            mLocationViewModel.list.value = list
        }
    }

    inner class ClickProxy {
        fun back() {
            finish()
        }
    }
}