

package com.kunminx.architecture.ui.binding_adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.kunminx.architecture.ui.layout_manager.WrapContentGridLayoutManager;
import com.kunminx.architecture.ui.layout_manager.WrapContentLinearLayoutManager;
import com.kunminx.architecture.ui.layout_manager.WrapContentStaggeredGridLayoutManager;

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

                if (recyclerView.getLayoutManager() != null) {

                    if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                        int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
                        recyclerView.setLayoutManager(new WrapContentGridLayoutManager(recyclerView.getContext(), spanCount));

                    } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(recyclerView.getContext()));

                    } else if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                        int spanCount = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
                        int orientation = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getOrientation();
                        recyclerView.setLayoutManager(new WrapContentStaggeredGridLayoutManager(spanCount, orientation));
                    }
                }

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
