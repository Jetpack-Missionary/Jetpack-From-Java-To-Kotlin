

package com.kunminx.jetpack_java.sample_one_more_thing.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.databinding.ActivityOneMoreThingBinding;
import com.kunminx.jetpack_java.sample_one_more_thing.ui.state.OneMoreThingViewModel;

/**
 * Create by KunMinX at 19/10/16
 */

public class OneMoreThingActivity extends BaseActivity {

    private OneMoreThingViewModel mOneMoreThingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOneMoreThingViewModel = getActivityViewModel(OneMoreThingViewModel.class);

        ActivityOneMoreThingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_one_more_thing);
        binding.setLifecycleOwner(this);
        binding.setVm(mOneMoreThingViewModel);
        binding.setClick(new ClickProxy());
    }

    public class ClickProxy {
        public void back() {
            finish();
        }
    }
}
