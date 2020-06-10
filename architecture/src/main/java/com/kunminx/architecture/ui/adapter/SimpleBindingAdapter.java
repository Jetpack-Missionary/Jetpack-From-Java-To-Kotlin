

package com.kunminx.architecture.ui.adapter;

import android.content.Context;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author KunMinX
 * Create at 2018/6/30
 */
public abstract class SimpleBindingAdapter<M, B extends ViewDataBinding> extends BaseBindingAdapter<M, B> {

    private final int layout;

    public SimpleBindingAdapter(Context context, int layout, @NonNull DiffUtil.ItemCallback<M> diffCallback) {
        super(context, diffCallback);
        this.layout = layout;
    }

    @Override
    protected @LayoutRes
    int getLayoutResId(int viewType) {
        return this.layout;
    }

}