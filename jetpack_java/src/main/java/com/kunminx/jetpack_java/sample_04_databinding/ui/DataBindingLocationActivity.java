

package com.kunminx.jetpack_java.sample_04_databinding.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.databinding.ActivityLocationDatabindingBinding;
import com.kunminx.jetpack_java.sample_02_livedata.domain.LiveDataLocationManager;
import com.kunminx.jetpack_java.sample_04_databinding.ui.adapter.DataBindingLocationAdapter;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.LocationViewModel;

/**
 * Create by KunMinX at 19/10/16
 */

public class DataBindingLocationActivity extends BaseActivity {

    private LocationViewModel mLocationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationViewModel = getActivityViewModel(LocationViewModel.class);

        ActivityLocationDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_location_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mLocationViewModel);
        binding.setClick(new ClickProxy());

        DataBindingLocationAdapter adapter = new DataBindingLocationAdapter(getApplicationContext());
        adapter.setOnItemClickListener(((item, position) -> {
            Intent intent = new Intent();
            intent.putExtra(Configs.LOCATION_RESULT, item.getLocationName());
            setResult(RESULT_OK, intent);
            finish();
        }));
        binding.setAdapter(adapter);

        getLifecycle().addObserver(LiveDataLocationManager.getInstance());

        LiveDataLocationManager.getInstance().getLocationBeans().observe(this, locationBeans -> {
            mLocationViewModel.list.setValue(locationBeans);
        });
    }

    public class ClickProxy {
        public void back() {
            finish();
        }
    }
}
