

package com.kunminx.puremusic.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.architecture.ui.adapter.SimpleBindingAdapter;
import com.kunminx.puremusic.R;
import com.kunminx.puremusic.data.bean.GridItem;
import com.kunminx.puremusic.databinding.AdapterGridItemBinding;

/**
 * Create by KunMinX at 20/4/19
 */
public class GridItemAdapter extends SimpleBindingAdapter<GridItem, AdapterGridItemBinding> {

    public GridItemAdapter(Context context) {
        super(context, R.layout.adapter_grid_item, new DiffUtil.ItemCallback<GridItem>() {
            @Override
            public boolean areItemsTheSame(@NonNull GridItem oldItem, @NonNull GridItem newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull GridItem oldItem, @NonNull GridItem newItem) {
                return oldItem.getUuid().equals(newItem.getUuid());
            }
        });
    }

    @Override
    protected void onBindItem(AdapterGridItemBinding binding, GridItem item, RecyclerView.ViewHolder holder) {
        binding.setItem(item);
    }
}
