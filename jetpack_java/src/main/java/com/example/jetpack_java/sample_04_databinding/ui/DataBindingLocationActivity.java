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

import com.example.jetpack_java.R;
import com.example.jetpack_java.common_data.Configs;
import com.example.jetpack_java.databinding.ActivityLocationDatabindingBinding;
import com.example.jetpack_java.sample_02_livedata.domain.LiveDataLocationManager;
import com.example.jetpack_java.sample_04_databinding.ui.adapter.DataBindingLocationAdapter;
import com.example.jetpack_java.sample_04_databinding.ui.state.LocationViewModel;
import com.kunminx.architecture.ui.BaseActivity;

/**
 * Create by KunMinX at 19/10/16
 */

public class DataBindingLocationActivity extends BaseActivity {

    private LocationViewModel mLocationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationViewModel = getActivityViewModel(LocationViewModel.class);

        ActivityLocationDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_location_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mLocationViewModel);

        DataBindingLocationAdapter adapter = new DataBindingLocationAdapter(getApplicationContext());
        adapter.setOnItemClickListener(((item, position) -> {
            Intent intent = new Intent();
            intent.putExtra(Configs.LOCATION_RESULT, item.getLocationName());
            setResult(RESULT_OK, intent);
            finish();
        }));
        binding.setAdapter(adapter);

        getLifecycle().addObserver(LiveDataLocationManager.getInstance());

        LiveDataLocationManager.getInstance().getLocationBeans().observe(this, locationBeans -> {
            mLocationViewModel.list.setValue(locationBeans);
        });
    }

}
