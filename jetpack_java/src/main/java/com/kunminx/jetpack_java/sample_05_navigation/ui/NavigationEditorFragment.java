/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
 * Create by KunMinX at 2020/5/30
 */
public class NavigationEditorFragment extends BaseFragment {

    private EditorViewModel mEditorViewModel;
    private SharedViewModel mSharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEditorViewModel = getFragmentViewModel(EditorViewModel.class);
        mSharedViewModel = getActivityViewModel(SharedViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editor_navigation, container, false);
        FragmentEditorNavigationBinding binding = FragmentEditorNavigationBinding.bind(view);
        binding.setLifecycleOwner(this);
        binding.setVm(mEditorViewModel);
        binding.setClick(new ClickProxy());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSharedViewModel.location.observe(getViewLifecycleOwner(), s -> {
            mEditorViewModel.location.set(s);
        });
    }

    public class ClickProxy implements Toolbar.OnMenuItemClickListener {

        public void locate() {
            nav().navigate(R.id.action_editorFragment_Navigation_to_locationFragment_Navigation);
        }

        public void addPic() {
            mEditorViewModel.imgUrl.set(APIs.SCENE_URL);
        }

        public void back() {
            nav().navigateUp();
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
                mSharedViewModel.moment.setValue(moment);
                nav().navigateUp();
            }
            return true;
        }
    }
}
