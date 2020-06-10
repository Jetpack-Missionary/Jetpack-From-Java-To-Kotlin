

package com.kunminx.jetpack_java.common_ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.kunminx.jetpack_java.common_data.bean.LocationBean;
import com.kunminx.jetpack_java.common_data.bean.Moment;

/**
 * Create by KunMinX at 2020/6/1
 */
public class DiffUtilCallbacks {

    public DiffUtil.ItemCallback<LocationBean> getLocationBeanItemCallback() {
        return new DiffUtil.ItemCallback<LocationBean>() {
            @Override
            public boolean areItemsTheSame(@NonNull LocationBean oldItem, @NonNull LocationBean newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull LocationBean oldItem, @NonNull LocationBean newItem) {
                return oldItem.getLocationName().equals(newItem.getLocationName());
            }
        };
    }

    public DiffUtil.ItemCallback<Moment> getMomentItemCallback() {
        return new DiffUtil.ItemCallback<Moment>() {
            @Override
            public boolean areItemsTheSame(@NonNull Moment oldItem, @NonNull Moment newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull Moment oldItem, @NonNull Moment newItem) {
                return oldItem.getUuid().equals(newItem.getUuid());
            }
        };
    }
}
