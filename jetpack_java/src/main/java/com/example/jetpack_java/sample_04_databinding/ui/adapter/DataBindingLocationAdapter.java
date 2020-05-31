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

package com.example.jetpack_java.sample_04_databinding.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpack_java.R;
import com.example.jetpack_java.common_data.bean.LocationBean;
import com.example.jetpack_java.databinding.AdapterLocationDatabindingBinding;
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter;

/**
 * Create by KunMinX at 2020/5/31
 */
public class DataBindingLocationAdapter extends SimpleBindingAdapter<LocationBean, AdapterLocationDatabindingBinding> {

    public DataBindingLocationAdapter(Context context) {
        super(context, R.layout.adapter_location_databinding, new DiffUtil.ItemCallback<LocationBean>() {
            @Override
            public boolean areItemsTheSame(@NonNull LocationBean oldItem, @NonNull LocationBean newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull LocationBean oldItem, @NonNull LocationBean newItem) {
                return oldItem.getLocationName().equals(newItem.getLocationName());
            }
        });
    }

    @Override
    protected void onBindItem(AdapterLocationDatabindingBinding binding, LocationBean item, RecyclerView.ViewHolder holder) {
        binding.setBean(item);
    }
}
