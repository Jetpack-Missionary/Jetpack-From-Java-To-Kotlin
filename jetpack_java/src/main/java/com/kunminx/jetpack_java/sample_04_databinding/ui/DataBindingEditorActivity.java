

package com.kunminx.jetpack_java.sample_04_databinding.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.APIs;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.common_data.bean.Moment;
import com.kunminx.jetpack_java.databinding.ActivityEditorDatabindingBinding;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.EditorViewModel;

import java.util.UUID;

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

public class DataBindingEditorActivity extends BaseActivity {

    private EditorViewModel mEditorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEditorViewModel = getActivityScopeViewModel(EditorViewModel.class);

        ActivityEditorDatabindingBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_editor_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mEditorViewModel);
        binding.setClick(new ClickProxy());
    }

    public class ClickProxy implements Toolbar.OnMenuItemClickListener {

        public void locate() {
            Intent intent = new Intent(DataBindingEditorActivity.this,
                    DataBindingLocationActivity.class);
            /*
             * startActivityForResult API 已弃用，可以使用新的 ActivityResult API
             * 详情见 https://github.com/Flywith24/Flywith24-ActivityResultRequest
             */
            startActivityForResult(intent, Configs.REQUEST_LOCATION_INFO);
        }

        public void addPic() {
            mEditorViewModel.imgUrl.set(APIs.SCENE_URL);
        }

        public void back() {
            finish();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (item.getItemId() == R.id.menu_save) {
                Moment moment = new Moment();
                moment.setUuid(UUID.randomUUID().toString());
                moment.setUserAvatar(APIs.KUNMINX_URL);
                moment.setUserName("KunMinX");
                moment.setLocation(mEditorViewModel.location.get());
                moment.setImgUrl(mEditorViewModel.imgUrl.get());
                moment.setContent(mEditorViewModel.content.get());
                setResult(Configs.REQUEST_NEW_MOMENT, new Intent().putExtra(Configs.NEW_MOMENT, moment));
                finish();
            }
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == Configs.REQUEST_LOCATION_INFO) {
            String location = data.getStringExtra(Configs.LOCATION_RESULT);
            mEditorViewModel.location.set(location);
        }
    }
}
