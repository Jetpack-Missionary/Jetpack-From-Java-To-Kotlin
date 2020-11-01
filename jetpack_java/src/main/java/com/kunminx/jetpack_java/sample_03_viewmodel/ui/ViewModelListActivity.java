

package com.kunminx.jetpack_java.sample_03_viewmodel.ui;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.architecture.ui.layout_manager.WrapContentLinearLayoutManager;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_ui.adapter.MomentAdapter;
import com.kunminx.jetpack_java.sample_03_viewmodel.ui.state.ListViewModel;

/**
 * TODO：本示例专注于提供 ViewModel 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
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

public class ViewModelListActivity extends BaseActivity {

    private ListViewModel mListViewModel;
    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private MomentAdapter mMomentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListViewModel = getActivityScopeViewModel(ListViewModel.class);

        setContentView(R.layout.activity_list_viewmodel);
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationOnClickListener(v -> finish());

        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(getApplicationContext()));

        mRecyclerView.setAdapter(mMomentAdapter = new MomentAdapter(getApplicationContext(), moment -> {
            showLongToast(getString(R.string.viewmodel_item_click_tip));
        }));

        mListViewModel.momentRequest.getListMutableLiveData().observe(this, moments -> {
            mMomentAdapter.submitList(moments);
        });

        mListViewModel.momentRequest.requestList();

    }

}
