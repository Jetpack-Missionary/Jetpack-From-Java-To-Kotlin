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

package com.kunminx.puremusic.ui.page;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kunminx.puremusic.BR;
import com.kunminx.puremusic.R;
import com.kunminx.puremusic.ui.base.BaseFragment;
import com.kunminx.puremusic.ui.base.DataBindingConfig;
import com.kunminx.puremusic.ui.page.adapter.DrawerAdapter;
import com.kunminx.puremusic.vm.state.DrawerViewModel;

/**
 * Create by KunMinX at 19/10/29
 */
public class DrawerFragment extends BaseFragment {

    private DrawerViewModel mDrawerViewModel;

    @Override
    protected void initViewModel() {
        mDrawerViewModel = getFragmentViewModel(DrawerViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_drawer, mDrawerViewModel)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, new DrawerAdapter(getContext()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDrawerViewModel.getLibraryLiveData().observe(getViewLifecycleOwner(), libraryInfos -> {
            if (mAnimationLoaded && libraryInfos != null) {
                mDrawerViewModel.list.setValue(libraryInfos);
            }
        });

//        mDrawerViewModel.requestLibraryInfo();
    }

    @Override
    public void loadInitData() {
        super.loadInitData();
        if (mDrawerViewModel.getLibraryLiveData().getValue() != null) {
            mDrawerViewModel.list.setValue(mDrawerViewModel.getLibraryLiveData().getValue());
        }
    }

    public class ClickProxy {

        public void logoClick() {
            String u = "https://github.com/KunMinX/Jetpack-MVVM-Best-Practice";
            Uri uri = Uri.parse(u);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

}
