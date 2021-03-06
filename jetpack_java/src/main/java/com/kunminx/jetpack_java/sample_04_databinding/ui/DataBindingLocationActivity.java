

package com.kunminx.jetpack_java.sample_04_databinding.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.databinding.ActivityLocationDatabindingBinding;
import com.kunminx.jetpack_java.sample_02_livedata.domain.LiveDataLocationManager;
import com.kunminx.jetpack_java.sample_04_databinding.ui.adapter.DataBindingLocationAdapter;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.LocationViewModel;

/**
 * TODO：本示例专注于提供 DataBinding 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
 * kotlin 模块提供同样的场景和基于 Kotlin 的写法，可对照查阅。
 * 并且本项目的示例从 sample_01 到 sample_05 是循序渐进地 Jetpack 化，
 * 如看完对 Jetpack 高频核心组件 "为什么要用"、"为什么要这样用" 有了一丝丝好奇心，可前往《Jetpack MVVM 精讲》和《Jetpack MVVM 最佳实践》项目查阅深度解析。
 * <p>
 * https://juejin.im/post/5dafc49b6fb9a04e17209922
 * <p>
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 * <p>
 * <p>
 * Create by KunMinX at 19/10/16
 */

public class DataBindingLocationActivity extends BaseActivity {

    private LocationViewModel mLocationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationViewModel = getActivityScopeViewModel(LocationViewModel.class);

        ActivityLocationDatabindingBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_location_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mLocationViewModel);
        binding.setClick(new ClickProxy());

        DataBindingLocationAdapter adapter = new DataBindingLocationAdapter(getApplicationContext());
        adapter.setOnItemClickListener(((item, position) -> {
            Intent intent = new Intent();
            intent.putExtra(Configs.LOCATION_RESULT, item.getLocationName());
            setResult(RESULT_OK, intent);
            finish();
        }));
        binding.setAdapter(adapter);

        getLifecycle().addObserver(LiveDataLocationManager.getInstance());

        LiveDataLocationManager.getInstance().getLocationBeans().observe(this, locationBeans -> {
            mLocationViewModel.list.setValue(locationBeans);
        });
    }

    public class ClickProxy {
        public void back() {
            finish();
        }
    }
}
