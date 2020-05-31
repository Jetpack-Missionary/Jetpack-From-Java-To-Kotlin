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
import com.example.jetpack_java.common_data.bean.Moment;
import com.example.jetpack_java.databinding.AdapterMomentDatabindingBinding;
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter;

/**
 * Create by KunMinX at 2020/5/31
 */
public class DataBindingMomentAdapter extends SimpleBindingAdapter<Moment, AdapterMomentDatabindingBinding> {

    public DataBindingMomentAdapter(Context context) {
        super(context, R.layout.adapter_moment_databinding, new DiffUtil.ItemCallback<Moment>() {
            @Override
            public boolean areItemsTheSame(@NonNull Moment oldItem, @NonNull Moment newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull Moment oldItem, @NonNull Moment newItem) {
                return oldItem.getUuid().equals(newItem.getUuid());
            }
        });
    }

    @Override
    protected void onBindItem(AdapterMomentDatabindingBinding binding, Moment item, RecyclerView.ViewHolder holder) {
        binding.setMoment(item);
    }
}
