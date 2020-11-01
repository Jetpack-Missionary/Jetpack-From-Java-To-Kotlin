

package com.kunminx.puremusic.ui.page;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.puremusic.R;
import com.kunminx.puremusic.databinding.ActivityMainBinding;
import com.kunminx.puremusic.ui.adapter.GridItemAdapter;
import com.kunminx.puremusic.ui.state.MainActivityViewModel;

/**
 * Create by KunMinX at 19/10/16
 */

public class MainActivity extends BaseActivity {

    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivityViewModel = getActivityScopeViewModel(MainActivityViewModel.class);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(mMainActivityViewModel);

        GridItemAdapter adapterJava = new GridItemAdapter(getApplicationContext());
        adapterJava.setOnItemClickListener((item, position) -> {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(item.getPackageName(), item.getActivityPath()));
            startActivity(intent);
        });
        binding.setAdapterJava(adapterJava);

        GridItemAdapter adapterKotlin = new GridItemAdapter(getApplicationContext());
        adapterKotlin.setOnItemClickListener(((item, position) -> {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(item.getPackageName(), item.getActivityPath()));
            startActivity(intent);
        }));
        binding.setAdapterKotlin(adapterKotlin);

        mMainActivityViewModel.getJavaItemsLiveData().observe(this, gridItems -> {
            mMainActivityViewModel.javaList.setValue(gridItems);
        });

        mMainActivityViewModel.getKotlinItemsLiveData().observe(this, gridItems -> {
            mMainActivityViewModel.kotlinList.setValue(gridItems);
        });

        mMainActivityViewModel.requestJavaItems();
        mMainActivityViewModel.requestKotlinItems();
    }

}
