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

package com.example.jetpack_java.sample_05_navigation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jetpack_java.R;
import com.example.jetpack_java.databinding.FragmentEditorNavigationBinding;
import com.example.jetpack_java.sample_04_databinding.ui.state.EditorViewModel;
import com.kunminx.architecture.ui.BaseFragment;

/**
 * Create by KunMinX at 2020/5/30
 */
public class EditorFragment_Navigation extends BaseFragment {

    private EditorViewModel mEditorViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEditorViewModel = getFragmentViewModel(EditorViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editor_navigation, container, false);
        FragmentEditorNavigationBinding binding = FragmentEditorNavigationBinding.bind(view);
        binding.setVm(mEditorViewModel);
        binding.setClick(new ClickProxy());

        return view;
    }

    public class ClickProxy {
        public void locate() {

        }
    }
}
