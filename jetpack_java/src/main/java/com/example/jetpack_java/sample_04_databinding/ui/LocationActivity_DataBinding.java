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
import com.example.jetpack_java.common_data.Configs;
import com.example.jetpack_java.common_data.bean.LocationBean;
import com.example.jetpack_java.databinding.ActivityLocationDatabindingBinding;
import com.example.jetpack_java.databinding.AdapterLocationDatabindingBinding;
import com.example.jetpack_java.sample_02_livedata.domain.LocationManager_LiveData;
import com.example.jetpack_java.sample_04_databinding.ui.state.LocationViewModel;
import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter;

/**
 * Create by KunMinX at 19/10/16
 */

public class LocationActivity_DataBinding extends BaseActivity {

    private LocationViewModel mLocationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationViewModel = getActivityViewModel(LocationViewModel.class);

        ActivityLocationDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_location_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mLocationViewModel);

        binding.setAdapter(new SimpleBindingAdapter<LocationBean, AdapterLocationDatabindingBinding>(getApplicationContext(), R.layout.adapter_location_databinding) {
            @Override
            protected void onSimpleBindItem(AdapterLocationDatabindingBinding binding, LocationBean item, RecyclerView.ViewHolder holder) {
                binding.setBean(item);
                binding.getRoot().setOnClickListener(v -> {
                    Intent intent = new Intent();
                    intent.putExtra(Configs.LOCATION_RESULT, item.getLocationName());
                    setResult(RESULT_OK, intent);
                    finish();
                });
            }
        });

        getLifecycle().addObserver(LocationManager_LiveData.getInstance());

        LocationManager_LiveData.getInstance().getLocationBeans().observe(this, locationBeans -> {
            mLocationViewModel.list.setValue(locationBeans);
        });
    }

}
