

package com.kunminx.jetpack_java.common_ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.bean.LocationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO：本示例专注于提供 Jetpack 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
 * kotlin 模块提供同样的场景和基于 Kotlin 的写法，可对照查阅。
 * 并且本项目的示例从 sample_01 到 sample_05 是循序渐进地 Jetpack 化，
 * 如看完对 Jetpack 高频核心组件 "为什么要用"、"为什么要这样用" 有了一丝丝好奇心，可前往《Jetpack MVVM 精讲》和《Jetpack MVVM 最佳实践》项目查阅深度解析。
 * <p>
 * https://juejin.im/post/5dafc49b6fb9a04e17209922
 * <p>
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 * <p>
 * <p>
 * Create by KunMinX at 2020/5/29
 */
public class LocationAdapter extends ListAdapter<LocationBean, LocationAdapter.ViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public LocationAdapter(Context context, OnItemClickListener listener) {
        super(new DiffUtilCallbacks().getLocationBeanItemCallback());
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public void submitList(@Nullable List<LocationBean> list) {
        super.submitList(list, () -> {
            super.submitList(list == null ? new ArrayList<>() : new ArrayList<>(list));
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_location, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(getItem(holder.getBindingAdapterPosition()));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTvTitle.setText(getItem(position).getLocationName());
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
