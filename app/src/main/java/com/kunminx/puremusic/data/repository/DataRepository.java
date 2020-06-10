

package com.kunminx.puremusic.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.kunminx.puremusic.R;
import com.kunminx.puremusic.data.bean.GridItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Create by KunMinX at 19/10/29
 */
public class DataRepository implements ILocalRequest, IRemoteRequest {

    private static final DataRepository S_REQUEST_MANAGER = new DataRepository();
    private MutableLiveData<String> responseCodeLiveData;

    private DataRepository() {
    }

    public static DataRepository getInstance() {
        return S_REQUEST_MANAGER;
    }

    public MutableLiveData<String> getResponseCodeLiveData() {
        if (responseCodeLiveData == null) {
            responseCodeLiveData = new MutableLiveData<>();
        }
        return responseCodeLiveData;
    }

    @Override
    public void getJavaItems(MutableLiveData<List<GridItem>> liveData) {

        List<GridItem> list = new ArrayList<>();
        list.add(new GridItem(getUUID(), "Lifecycles", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.kunminx.jetpack_java.sample_01_lifecycles.ui.LifecycleEditorActivity"));
        list.add(new GridItem(getUUID(), "LiveData", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.kunminx.jetpack_java.sample_02_livedata.ui.LiveDataEditorActivity"));
        list.add(new GridItem(getUUID(), "ViewModel", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.kunminx.jetpack_java.sample_03_viewmodel.ui.ViewModelListActivity"));
        list.add(new GridItem(getUUID(), "DataBinding", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.kunminx.jetpack_java.sample_04_databinding.ui.DataBindingListActivity"));
        list.add(new GridItem(getUUID(), "Navigation", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.kunminx.jetpack_java.sample_05_navigation.ui.NavigationMainActivity"));
        list.add(new GridItem(getUUID(), "One More Thing", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.kunminx.jetpack_java.sample_one_more_thing.ui.OneMoreThingActivity"));

        liveData.setValue(list);
    }

    @Override
    public void getKotlinItems(MutableLiveData<List<GridItem>> liveData) {

        List<GridItem> list = new ArrayList<>();
        list.add(new GridItem(getUUID(), "Lifecycles", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.flywith24.jetpack_kotlin.sample_01_lifecycles.ui.LifecycleEditorActivity"));
        list.add(new GridItem(getUUID(), "LiveData", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.flywith24.jetpack_kotlin.sample_02_livedata.ui.LiveDataEditorActivity"));
        list.add(new GridItem(getUUID(), "ViewModel", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.flywith24.jetpack_kotlin.sample_03_viewmodel.ui.ViewModelListActivity"));
        list.add(new GridItem(getUUID(), "DataBinding", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.flywith24.jetpack_kotlin.sample_04_databinding.ui.DataBindingListActivity"));
        list.add(new GridItem(getUUID(), "Navigation", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.flywith24.jetpack_kotlin.sample_05_navigation.ui.NavigationMainActivity"));
        list.add(new GridItem(getUUID(), "One More Thing", R.drawable.bg_album_default, "com.kunminx.jetpack_j2k", "com.flywith24.jetpack_kotlin.sample_one_more_thing.ui.OneMoreThingActivity"));

        liveData.setValue(list);
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
