

package com.kunminx.jetpack_java.sample_one_more_thing.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.databinding.ActivityOneMoreThingBinding;
import com.kunminx.jetpack_java.sample_one_more_thing.ui.state.OneMoreThingViewModel;

/**
 * TODO：本示例专注于提供 Jetpack 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
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

public class OneMoreThingActivity extends BaseActivity {

    private OneMoreThingViewModel mOneMoreThingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOneMoreThingViewModel = getActivityScopeViewModel(OneMoreThingViewModel.class);

        ActivityOneMoreThingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_one_more_thing);
        binding.setLifecycleOwner(this);
        binding.setVm(mOneMoreThingViewModel);
        binding.setClick(new ClickProxy());
    }

    public class ClickProxy {
        public void back() {
            finish();
        }
    }
}
