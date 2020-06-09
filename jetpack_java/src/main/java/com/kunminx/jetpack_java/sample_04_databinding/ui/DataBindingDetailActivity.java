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

package com.kunminx.jetpack_java.sample_04_databinding.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.common_data.bean.Moment;
import com.kunminx.jetpack_java.databinding.ActivityDetailDatabindingBinding;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.DetailViewModel;

/**
 * Create by KunMinX at 19/10/16
 */

public class DataBindingDetailActivity extends BaseActivity {

    private DetailViewModel mDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailViewModel = getActivityViewModel(DetailViewModel.class);

        ActivityDetailDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mDetailViewModel);
        binding.setClick(new ClickProxy());

        Moment moment = (Moment) getIntent().getParcelableExtra(Configs.THIS_MOMENT);
        mDetailViewModel.initState(moment);

    }

    public class ClickProxy {
        public void back() {
            finish();
        }
    }

}
