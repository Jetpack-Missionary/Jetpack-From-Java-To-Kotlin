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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jetpack_java.R;
import com.example.jetpack_java.common_data.bean.Moment;

/**
 * Create by KunMinX at 2020/5/29
 */
public class MomentAdapter extends ListAdapter<Moment, MomentAdapter.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public MomentAdapter(Context context, OnItemClickListener listener) {
        super(new DiffUtil.ItemCallback<Moment>() {
            @Override
            public boolean areItemsTheSame(@NonNull Moment oldItem, @NonNull Moment newItem) {
                return oldItem.getUuid().equals(newItem.getUuid());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Moment oldItem, @NonNull Moment newItem) {
                return oldItem.getUserName().equals(newItem.getUserName())
                        && oldItem.getContent().equals(newItem.getContent())
                        && oldItem.getLocation().equals(newItem.getLocation())
                        && oldItem.getImgUrl().equals(newItem.getImgUrl())
                        && oldItem.getUserAvatar().equals(newItem.getUserAvatar());
            }
        });
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_moment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Moment moment = getItem(position);

        holder.tvName.setText(moment.getUserName());
        holder.tvContent.setText(moment.getContent());
        holder.tvLocation.setText(moment.getLocation());
        Glide.with(mContext).load(moment.getUserAvatar()).into(holder.ivAvatar);
        Glide.with(mContext).load(moment.getImgUrl()).into(holder.ivPreview);

        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(moment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvContent;
        private TextView tvLocation;
        private ImageView ivAvatar;
        private ImageView ivPreview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvLocation = itemView.findViewById(R.id.tv_location);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            ivPreview = itemView.findViewById(R.id.iv_preview);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Moment moment);
    }
}
