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
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpack_java.R;
import com.example.jetpack_java.common_data.bean.LocationBean;
import com.example.jetpack_java.databinding.AdapterLocationDatabindingBinding;
import com.example.jetpack_java.databinding.FragmentLocationNavigationBinding;
import com.example.jetpack_java.sample_04_databinding.ui.state.LocationViewModel;
import com.kunminx.architecture.ui.BaseFragment;
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter;

/**
 * Create by KunMinX at 2020/5/30
 */
public class LocationFragment_Navigation extends BaseFragment {

    private LocationViewModel mLocationViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationViewModel = getFragmentViewModel(LocationViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_navigation, container, false);
        FragmentLocationNavigationBinding binding = FragmentLocationNavigationBinding.bind(view);
        binding.setVm(mLocationViewModel);
        binding.setAdapter(new SimpleBindingAdapter<LocationBean, AdapterLocationDatabindingBinding>(mActivity.getApplicationContext(), R.layout.adapter_location_databinding) {
            @Override
            protected void onSimpleBindItem(AdapterLocationDatabindingBinding binding, LocationBean item, RecyclerView.ViewHolder holder) {
                binding.setBean(item);
                binding.getRoot().setOnClickListener(v -> {
//                    Intent intent = new Intent();
//                    intent.putExtra(Configs.LOCATION_RESULT, item.getLocationName());
//                    setResult(RESULT_OK, intent);
//                    finish();
                });
            }
        });

        return view;
    }

}
