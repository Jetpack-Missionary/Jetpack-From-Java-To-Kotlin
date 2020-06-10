

package com.kunminx.jetpack_java.sample_04_databinding.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.bean.Moment;
import com.kunminx.jetpack_java.common_ui.adapter.DiffUtilCallbacks;
import com.kunminx.jetpack_java.databinding.AdapterMomentDatabindingBinding;
import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter;

/**
 * Create by KunMinX at 2020/5/31
 */
public class DataBindingMomentAdapter extends SimpleBindingAdapter<Moment, AdapterMomentDatabindingBinding> {

    public DataBindingMomentAdapter(Context context) {
        super(context, R.layout.adapter_moment_databinding, new DiffUtilCallbacks().getMomentItemCallback());
    }

    @Override
    protected void onBindItem(AdapterMomentDatabindingBinding binding, Moment item, RecyclerView.ViewHolder holder) {
        binding.setMoment(item);
    }
}
