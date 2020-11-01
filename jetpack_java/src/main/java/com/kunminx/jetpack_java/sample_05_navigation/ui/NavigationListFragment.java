

package com.kunminx.jetpack_java.sample_05_navigation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kunminx.architecture.ui.BaseFragment;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.databinding.FragmentListNavigationBinding;
import com.kunminx.jetpack_java.sample_04_databinding.ui.adapter.DataBindingMomentAdapter;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.ListViewModel;
import com.kunminx.jetpack_java.sample_05_navigation.ui.callback.SharedViewModel;

/**
 * TODO：本示例专注于提供 Navigation 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
 * kotlin 模块提供同样的场景和基于 Kotlin 的写法，可对照查阅。
 * 并且本项目的示例从 sample_01 到 sample_05 是循序渐进地 Jetpack 化，
 * 如看完对 Jetpack 高频核心组件 "为什么要用"、"为什么要这样用" 有了一丝丝好奇心，可前往《Jetpack MVVM 精讲》和《Jetpack MVVM 最佳实践》项目查阅深度解析。
 * <p>
 * https://juejin.im/post/5dafc49b6fb9a04e17209922
 * <p>
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 * <p>
 * <p>
 * Create by KunMinX at 2020/5/30
 */
public class NavigationListFragment extends BaseFragment {

    private ListViewModel mListState;
    private SharedViewModel mPageCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListState = getFragmentScopeViewModel(ListViewModel.class);
        mPageCallback = getActivityScopeViewModel(SharedViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_navigation, container, false);
        FragmentListNavigationBinding binding = FragmentListNavigationBinding.bind(view);
        binding.setLifecycleOwner(this);
        binding.setVm(mListState);
        binding.setClick(new ClickProxy());

        DataBindingMomentAdapter adapter = new DataBindingMomentAdapter(mActivity.getApplicationContext());
        adapter.setOnItemClickListener(((item, position) -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Configs.THIS_MOMENT, item);
            nav().navigate(R.id.action_listFragment_Navigation_to_detailFragment_Navigation, bundle);
        }));
        binding.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListState.momentRequest.getListMutableLiveData().observe(getViewLifecycleOwner(), moments -> {
            mListState.list.setValue(moments);
        });

        mPageCallback.getMoment().observeInFragment(this, moment -> {
            mListState.list.getValue().add(0, moment);
            mListState.list.setValue(mListState.list.getValue());
        });

        mListState.momentRequest.requestList();
    }

    public class ClickProxy {
        public void fabClick() {
            nav().navigate(R.id.action_listFragment_Navigation_to_editorFragment_Navigation);
        }

        public void back() {
            mPageCallback.requestCloseActivity();
        }
    }
}
