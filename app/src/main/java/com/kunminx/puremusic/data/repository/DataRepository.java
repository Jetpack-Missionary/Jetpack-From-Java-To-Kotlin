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

package com.kunminx.puremusic.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.kunminx.puremusic.R;
import com.kunminx.puremusic.data.bean.GridItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by KunMinX at 19/10/29
 */
public class DataRepository implements ILocalRequest, IRemoteRequest {

    private static final DataRepository S_REQUEST_MANAGER = new DataRepository();
    private MutableLiveData<String> responseCodeLiveData;

    private DataRepository() {
    }

    public static DataRepository getInstance() {
        return S_REQUEST_MANAGER;
    }

    public MutableLiveData<String> getResponseCodeLiveData() {
        if (responseCodeLiveData == null) {
            responseCodeLiveData = new MutableLiveData<>();
        }
        return responseCodeLiveData;
    }

    @Override
    public void getJavaItems(MutableLiveData<List<GridItem>> liveData) {

        List<GridItem> list = new ArrayList<>();
        list.add(new GridItem("Lifecycles", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_java.sample_01_lifecycles.ui.LifecycleEditorActivity"));
        list.add(new GridItem("LiveData", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_java.sample_02_livedata.ui.LiveDataEditorActivity"));
        list.add(new GridItem("ViewModel", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_java.sample_03_viewmodel.ui.ViewModelListActivity"));
        list.add(new GridItem("DataBinding", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_java.sample_04_databinding.ui.DataBindingListActivity"));
        list.add(new GridItem("Navigation", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_java.sample_05_navigation.ui.NavigationMainActivity"));
        list.add(new GridItem("Room", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_java.sample_01_lifecycles.ui.LifecycleDetailActivity"));
        list.add(new GridItem("Paging", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_java.sample_01_lifecycles.ui.LifecycleDetailActivity"));
        list.add(new GridItem("One More Thing", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_java.sample_01_lifecycles.ui.LifecycleDetailActivity"));

        liveData.setValue(list);
    }

    @Override
    public void getKotlinItems(MutableLiveData<List<GridItem>> liveData) {

        List<GridItem> list = new ArrayList<>();
        list.add(new GridItem("Lifecycles", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_kotlin.sample_01_lifecycles.ui.LifecycleDetailActivity"));
        list.add(new GridItem("LiveData", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_kotlin.sample_02_livedata.ui.LiveDataListActivity"));
        list.add(new GridItem("ViewModel", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_kotlin.sample_03_viewmodel.ui.ViewModelListActivity"));
        list.add(new GridItem("DataBinding", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_kotlin.sample_04_databinding.ui.DataBindingListActivity"));
        list.add(new GridItem("Navigation", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_kotlin.sample_05_navigation.ui.NavigationMainActivity"));
        list.add(new GridItem("Room", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_kotlin.sample_01_lifecycles.ui.LifecycleDetailActivity"));
        list.add(new GridItem("Paging", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_kotlin.sample_01_lifecycles.ui.LifecycleDetailActivity"));
        list.add(new GridItem("XX", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.example.jetpack_kotlin.sample_01_lifecycles.ui.LifecycleDetailActivity"));

        liveData.setValue(list);
    }

}
