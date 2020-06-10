

package com.kunminx.jetpack_java.sample_05_navigation.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.sample_05_navigation.ui.callback.SharedViewModel;

/**
 * Create by KunMinX at 19/10/16
 */

public class NavigationMainActivity extends BaseActivity {

    private SharedViewModel mSharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedViewModel = getActivityViewModel(SharedViewModel.class);

        DataBindingUtil.setContentView(this, R.layout.activity_main_navigation);

        mSharedViewModel.closeActivity.observe(this, aBoolean -> {
            finish();
        });
    }

}
