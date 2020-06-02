/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
