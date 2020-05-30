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

package com.example.jetpack_java.sample_04_databinding.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpack_java.R;
import com.example.jetpack_java.databinding.ActivityDatabindingListBinding;
import com.example.jetpack_java.databinding.AdapterDatabindingMomentBinding;
import com.example.jetpack_java.sample_01_lifecycles.data.Configs;
import com.example.jetpack_java.sample_04_databinding.data.bean.Moment;
import com.example.jetpack_java.sample_04_databinding.ui.state.ListViewModel;
import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter;

/**
 * Create by KunMinX at 19/10/16
 */

public class DataBindingListActivity extends BaseActivity {

    private ListViewModel mListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListViewModel = getActivityViewModel(ListViewModel.class);

        ActivityDatabindingListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_list);

        binding.setVm(mListViewModel);

        binding.setAdapter(new SimpleBindingAdapter<Moment, AdapterDatabindingMomentBinding>(getApplicationContext(), R.layout.adapter_databinding_moment) {
            @Override
            protected void onSimpleBindItem(AdapterDatabindingMomentBinding binding, Moment moment, RecyclerView.ViewHolder holder) {
                Intent intent = new Intent(DataBindingListActivity.this, DataBindingDetailActivity.class);
                intent.putExtra(Configs.THIS_MOMENT, moment);
                startActivity(intent);
            }
        });

        mListViewModel.getListMutableLiveData().observe(this, moments -> {
            mListViewModel.list.setValue(moments);
        });

        mListViewModel.requestList();
    }

}
