

package com.kunminx.jetpack_java.sample_04_databinding.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.bean.LocationBean;
import com.kunminx.jetpack_java.common_ui.adapter.DiffUtilCallbacks;
import com.kunminx.jetpack_java.databinding.AdapterLocationDatabindingBinding;
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter;

/**
 * Create by KunMinX at 2020/5/31
 */
public class DataBindingLocationAdapter extends SimpleBindingAdapter<LocationBean, AdapterLocationDatabindingBinding> {

    public DataBindingLocationAdapter(Context context) {
        super(context, R.layout.adapter_location_databinding, new DiffUtilCallbacks().getLocationBeanItemCallback());
    }

    @Override
    protected void onBindItem(AdapterLocationDatabindingBinding binding, LocationBean item, RecyclerView.ViewHolder holder) {
        binding.setBean(item);
    }
}
