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

package com.example.jetpack_java.sample_03_viewmodel.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpack_java.R;
import com.example.jetpack_java.common_ui.adapter.MomentAdapter;
import com.example.jetpack_java.sample_03_viewmodel.ui.state.ListViewModel;
import com.kunminx.architecture.ui.BaseActivity;

/**
 * Create by KunMinX at 19/10/16
 */

public class ListActivity_ViewModel extends BaseActivity {

    private ListViewModel mListViewModel;
    private RecyclerView mRecyclerView;
    private MomentAdapter mMomentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListViewModel = getActivityViewModel(ListViewModel.class);

        setContentView(R.layout.activity_list_viewmodel);

        mRecyclerView = findViewById(R.id.rv);

        mRecyclerView.setAdapter(mMomentAdapter = new MomentAdapter(getApplicationContext(), moment -> {

        }));

        mListViewModel.getListMutableLiveData().observe(this, moments -> {
            mMomentAdapter.submitList(moments);
        });

        mListViewModel.requestList();

    }

}
