

package com.kunminx.jetpack_java.sample_03_viewmodel.ui;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_ui.adapter.MomentAdapter;
import com.kunminx.jetpack_java.sample_03_viewmodel.ui.state.ListViewModel;

/**
 * Create by KunMinX at 19/10/16
 */

public class ViewModelListActivity extends BaseActivity {

    private ListViewModel mListViewModel;
    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private MomentAdapter mMomentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListViewModel = getActivityViewModel(ListViewModel.class);

        setContentView(R.layout.activity_list_viewmodel);
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationOnClickListener(v -> finish());

        mRecyclerView = findViewById(R.id.rv);

        mRecyclerView.setAdapter(mMomentAdapter = new MomentAdapter(getApplicationContext(), moment -> {
            showLongToast(getString(R.string.viewmodel_item_click_tip));
        }));

        mListViewModel.getListMutableLiveData().observe(this, moments -> {
            mMomentAdapter.submitList(moments);
        });

        mListViewModel.requestList();

    }

}
