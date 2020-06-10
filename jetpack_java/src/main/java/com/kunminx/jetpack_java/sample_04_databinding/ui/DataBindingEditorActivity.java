

package com.kunminx.jetpack_java.sample_04_databinding.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.kunminx.architecture.ui.BaseActivity;
import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.APIs;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.common_data.bean.Moment;
import com.kunminx.jetpack_java.databinding.ActivityEditorDatabindingBinding;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.EditorViewModel;

import java.util.UUID;

/**
 * Create by KunMinX at 19/10/16
 */

public class DataBindingEditorActivity extends BaseActivity {

    private EditorViewModel mEditorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEditorViewModel = getActivityViewModel(EditorViewModel.class);

        ActivityEditorDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_editor_databinding);
        binding.setLifecycleOwner(this);
        binding.setVm(mEditorViewModel);
        binding.setClick(new ClickProxy());
    }

    public class ClickProxy implements Toolbar.OnMenuItemClickListener {

        public void locate() {
            Intent intent = new Intent(DataBindingEditorActivity.this, DataBindingLocationActivity.class);
            startActivityForResult(intent, Configs.REQUEST_LOCATION_INFO);
        }

        public void addPic() {
            mEditorViewModel.imgUrl.set(APIs.SCENE_URL);
        }

        public void back() {
            finish();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (item.getItemId() == R.id.menu_save) {
                Moment moment = new Moment();
                moment.setUuid(UUID.randomUUID().toString());
                moment.setUserAvatar(APIs.KUNMINX_URL);
                moment.setUserName("KunMinX");
                moment.setLocation(mEditorViewModel.location.get());
                moment.setImgUrl(mEditorViewModel.imgUrl.get());
                moment.setContent(mEditorViewModel.content.get());
                setResult(Configs.REQUEST_NEW_MOMENT, new Intent().putExtra(Configs.NEW_MOMENT, moment));
                finish();
            }
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == Configs.REQUEST_LOCATION_INFO) {
            String location = data.getStringExtra(Configs.LOCATION_RESULT);
            mEditorViewModel.location.set(location);
        }
    }
}
