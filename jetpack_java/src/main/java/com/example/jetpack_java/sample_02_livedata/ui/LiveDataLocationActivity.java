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

package com.example.jetpack_java.sample_02_livedata.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpack_java.R;
import com.example.jetpack_java.common_data.Configs;
import com.example.jetpack_java.common_ui.adapter.LocationAdapter;
import com.example.jetpack_java.sample_02_livedata.domain.LiveDataLocationManager;
import com.kunminx.architecture.ui.BaseActivity;

/**
 * Create by KunMinX at 19/10/16
 */

public class LiveDataLocationActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private LocationAdapter mLocationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location_lifecycles);

        mRecyclerView = findViewById(R.id.rv);

        mRecyclerView.setAdapter(mLocationAdapter = new LocationAdapter(getApplicationContext(), locationBean -> {
            Intent intent = new Intent();
            intent.putExtra(Configs.LOCATION_RESULT, locationBean.getLocationName());
            setResult(RESULT_OK, intent);
            finish();
        }));

        getLifecycle().addObserver(LiveDataLocationManager.getInstance());

        LiveDataLocationManager.getInstance().getLocationBeans().observe(this, locationBeans -> {
            mLocationAdapter.submitList(locationBeans);
        });

    }

}
