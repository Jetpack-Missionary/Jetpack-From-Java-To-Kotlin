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

package com.example.jetpack_java.common_ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpack_java.R;
import com.example.jetpack_java.common_data.bean.LocationBean;

/**
 * Create by KunMinX at 2020/5/29
 */
public class LocationAdapter extends ListAdapter<LocationBean, LocationAdapter.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public LocationAdapter(Context context, OnItemClickListener listener) {
        super(new DiffUtil.ItemCallback<LocationBean>() {
            @Override
            public boolean areItemsTheSame(@NonNull LocationBean oldItem, @NonNull LocationBean newItem) {
                return oldItem.getLocationName().equals(newItem.getLocationName());
            }

            @Override
            public boolean areContentsTheSame(@NonNull LocationBean oldItem, @NonNull LocationBean newItem) {
                return oldItem.getLocationName().equals(newItem.getLocationName());
            }
        });
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_location, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTvTitle.setText(getItem(position).getLocationName());
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(getItem(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(LocationBean locationBean);
    }
}
