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

package com.kunminx.puremusic.ui.adapter;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.architecture.ui.adapter.SimpleBaseBindingAdapter;
import com.kunminx.puremusic.R;
import com.kunminx.puremusic.data.bean.GridItem;
import com.kunminx.puremusic.databinding.AdapterGridItemBinding;

/**
 * Create by KunMinX at 20/4/19
 */
public class GridItemAdapter extends SimpleBaseBindingAdapter<GridItem, AdapterGridItemBinding> {

    public GridItemAdapter(Context context) {
        super(context, R.layout.adapter_grid_item);
    }

    @Override
    protected void onSimpleBindItem(AdapterGridItemBinding binding, GridItem item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);

        //TODO 为隔离测试环境，点击跳转到新的 Activity

        binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName(item.getPackageName(), item.getActivityName());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        });
    }
}
