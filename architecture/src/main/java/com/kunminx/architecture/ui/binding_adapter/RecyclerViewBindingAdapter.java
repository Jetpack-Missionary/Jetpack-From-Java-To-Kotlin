

package com.kunminx.architecture.ui.binding_adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Create by KunMinX at 20/4/18
 */
public class RecyclerViewBindingAdapter {

    @BindingAdapter(value = {"setSpanCount"})
    public static void setSpanCount(RecyclerView recyclerView, int spanCount) {
        if (recyclerView != null) {
            if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), spanCount));
            } else {
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    ((GridLayoutManager) recyclerView.getLayoutManager()).setSpanCount(spanCount);
                }
            }
        }
    }

    @BindingAdapter(value = {"adapter", "refreshList", "autoScrollToTopWhenInsert", "autoScrollToBottomWhenInsert"}, requireAll = false)
    public static void bindList(RecyclerView recyclerView, ListAdapter adapter, List list,
                                boolean autoScrollToTopWhenInsert, boolean autoScrollToBottomWhenInsert) {

        if (recyclerView != null && list != null) {
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(adapter);

                adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                    @Override
                    public void onItemRangeInserted(int positionStart, int itemCount) {
                        if (autoScrollToTopWhenInsert) {
                            recyclerView.scrollToPosition(0);
                        } else if (autoScrollToBottomWhenInsert) {
                            recyclerView.scrollToPosition(recyclerView.getAdapter().getItemCount());
                        }
                    }
                });
            }

            adapter.submitList(list);
        }
    }
}
