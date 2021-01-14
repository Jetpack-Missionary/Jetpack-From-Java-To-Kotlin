

package com.kunminx.jetpack_java.sample_05_navigation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.kunminx.architecture.ui.BaseFragment;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.APIs;
import com.kunminx.jetpack_java.common_data.bean.Moment;
import com.kunminx.jetpack_java.databinding.FragmentEditorNavigationBinding;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.EditorViewModel;
import com.kunminx.jetpack_java.sample_05_navigation.ui.callback.SharedViewModel;

import java.util.UUID;

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
public class NavigationEditorFragment extends BaseFragment {

    private EditorViewModel mEditorState;
    private SharedViewModel mPageCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEditorState = getFragmentScopeViewModel(EditorViewModel.class);
        mPageCallback = getActivityScopeViewModel(SharedViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editor_navigation, container, false);
        FragmentEditorNavigationBinding binding = FragmentEditorNavigationBinding.bind(view);
        binding.setLifecycleOwner(this);
        binding.setVm(mEditorState);
        binding.setClick(new ClickProxy());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPageCallback.getLocation().observeInFragment(this, s -> {
            mEditorState.location.set(s);
        });
    }

    public class ClickProxy implements Toolbar.OnMenuItemClickListener {

        public void locate() {
            nav().navigate(R.id.action_editorFragment_Navigation_to_locationFragment_Navigation);
        }

        public void addPic() {
            mEditorState.imgUrl.set(APIs.SCENE_URL);
        }

        public void back() {
            nav().navigateUp();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (item.getItemId() == R.id.menu_save) {
                toggleKeyboardShow();
                Moment moment = new Moment();
                moment.setUuid(UUID.randomUUID().toString());
                moment.setUserAvatar(APIs.KUNMINX_URL);
                moment.setUserName("KunMinX");
                moment.setLocation(mEditorState.location.get());
                moment.setImgUrl(mEditorState.imgUrl.get());
                moment.setContent(mEditorState.content.get());
                mPageCallback.requestAddMoment(moment);
                nav().navigateUp();
            }
            return true;
        }
    }
}
