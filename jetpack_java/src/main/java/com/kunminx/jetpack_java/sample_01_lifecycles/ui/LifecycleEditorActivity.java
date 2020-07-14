

package com.kunminx.jetpack_java.sample_01_lifecycles.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.APIs;
import com.kunminx.jetpack_java.common_data.Configs;

/**
 * TODO：本示例专注于提供 Lifecycle 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
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

public class LifecycleEditorActivity extends BaseActivity {

    private TextView mTvLocation;
    private ImageView mImageView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_editor_lifecycle);

        mTvLocation = findViewById(R.id.tv_locate);
        mImageView = findViewById(R.id.iv);
        mToolbar = findViewById(R.id.toolbar);

        mToolbar.setNavigationOnClickListener(v -> {
            finish();
        });

        mToolbar.inflateMenu(R.menu.editor_menu);
        mToolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_save) {
                showLongToast(getString(R.string.lifecycle_save_tip));
            }
            return true;
        });

        Glide.with(this).load(APIs.SCENE_URL).into(mImageView);

        mTvLocation.setOnClickListener(v -> {
            Intent intent = new Intent(this, LifecycleLocationActivity.class);
            /*
             * startActivityForResult API 已弃用，可以使用新的 ActivityResult API
             * 详情见 https://github.com/Flywith24/Flywith24-ActivityResultRequest
             */
            startActivityForResult(intent, Configs.REQUEST_LOCATION_INFO);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == Configs.REQUEST_LOCATION_INFO) {
            String location = data.getStringExtra(Configs.LOCATION_RESULT);
            mTvLocation.setText(location);
        }
    }
}
