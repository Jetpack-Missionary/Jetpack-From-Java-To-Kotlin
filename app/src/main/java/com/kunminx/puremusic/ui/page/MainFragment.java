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

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kunminx.puremusic.BR;
import com.kunminx.puremusic.R;
import com.kunminx.puremusic.ui.base.BaseFragment;
import com.kunminx.puremusic.ui.base.DataBindingConfig;
import com.kunminx.puremusic.ui.page.adapter.GridItemAdapter;
import com.kunminx.puremusic.vm.state.MainViewModel;

/**
 * Create by KunMinX at 19/10/29
 */
public class MainFragment extends BaseFragment {

    private MainViewModel mMainViewModel;

    @Override
    protected void initViewModel() {
        mMainViewModel = getFragmentViewModel(MainViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_main, mMainViewModel)
                .addBindingParam(BR.click, new ClickProxy())
                .addBindingParam(BR.adapter, new GridItemAdapter(getContext()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mMainViewModel.getJavaItemsLiveData().observe(getViewLifecycleOwner(), gridItems -> {
            mMainViewModel.javaList.setValue(gridItems);
        });

        mMainViewModel.getKotlinItemsLiveData().observe(getViewLifecycleOwner(), gridItems -> {
            mMainViewModel.kotlinList.setValue(gridItems);
        });

        mMainViewModel.requestJavaItems();
        mMainViewModel.requestKotlinItems();
    }

    public class ClickProxy {

        public void openMenu() {
            getSharedViewModel().openOrCloseDrawer.setValue(true);
        }

        public void login() {
//            nav().navigate(R.id.action_mainFragment_to_loginFragment);
        }

        public void search() {
//            nav().navigate(R.id.action_mainFragment_to_searchFragment);
        }

    }

}
