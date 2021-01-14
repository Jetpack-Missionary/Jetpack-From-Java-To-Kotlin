

package com.kunminx.jetpack_java.sample_04_databinding.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.common_data.bean.Moment;
import com.kunminx.jetpack_java.databinding.ActivityListDatabindingBinding;
import com.kunminx.jetpack_java.sample_04_databinding.ui.adapter.DataBindingMomentAdapter;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.ListViewModel;

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

public class DataBindingListActivity extends BaseActivity {

    private ListViewModel mListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListViewModel = getActivityScopeViewModel(ListViewModel.class);

        ActivityListDatabindingBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_list_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mListViewModel);
        binding.setClick(new ClickProxy());

        DataBindingMomentAdapter adapter = new DataBindingMomentAdapter(getApplicationContext());
        adapter.setOnItemClickListener(((item, position) -> {
            Intent intent = new Intent(DataBindingListActivity.this, DataBindingDetailActivity.class);
            intent.putExtra(Configs.THIS_MOMENT, item);
            startActivity(intent);
        }));
        binding.setAdapter(adapter);

        mListViewModel.momentRequest.getListMutableLiveData().observe(this, moments -> {
            mListViewModel.list.setValue(moments);
        });

        mListViewModel.momentRequest.requestList();
    }

    public class ClickProxy {
        public void fabClick() {
            Intent intent = new Intent(DataBindingListActivity.this, DataBindingEditorActivity.class);
            /*
             * startActivityForResult API 已弃用，可以使用新的 ActivityResult API
             * 详情见 https://github.com/Flywith24/Flywith24-ActivityResultRequest
             */
            startActivityForResult(intent, Configs.REQUEST_NEW_MOMENT);
        }

        public void back() {
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == Configs.REQUEST_NEW_MOMENT) {
            Moment moment = data.getParcelableExtra(Configs.NEW_MOMENT);
            mListViewModel.list.getValue().add(0, moment);
            mListViewModel.list.setValue(mListViewModel.list.getValue());
        }
    }
}
