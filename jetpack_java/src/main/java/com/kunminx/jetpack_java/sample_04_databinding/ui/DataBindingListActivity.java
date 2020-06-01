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

package com.kunminx.jetpack_java.sample_04_databinding.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.databinding.ActivityListDatabindingBinding;
import com.kunminx.jetpack_java.sample_04_databinding.ui.adapter.DataBindingMomentAdapter;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.ListViewModel;
import com.kunminx.architecture.ui.BaseActivity;

/**
 * Create by KunMinX at 19/10/16
 */

public class DataBindingListActivity extends BaseActivity {

    private ListViewModel mListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListViewModel = getActivityViewModel(ListViewModel.class);

        ActivityListDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mListViewModel);
        binding.setClick(new ClickProxy());

        DataBindingMomentAdapter adapter = new DataBindingMomentAdapter(getApplicationContext());
        adapter.setOnItemClickListener(((item, position) -> {
            Intent intent = new Intent(DataBindingListActivity.this, DataBindingDetailActivity.class);
            intent.putExtra(Configs.THIS_MOMENT, item);
            startActivity(intent);
        }));
        binding.setAdapter(adapter);

        mListViewModel.getListMutableLiveData().observe(this, moments -> {
            mListViewModel.list.setValue(moments);
        });

        mListViewModel.requestList();
    }

    public class ClickProxy {
        public void fabClick() {
            Intent intent = new Intent(DataBindingListActivity.this, DataBindingEditorActivity.class);
            startActivity(intent);
        }
    }
}
