

package com.kunminx.puremusic.ui.state;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kunminx.puremusic.data.bean.GridItem;
import com.kunminx.puremusic.domain.request.GridItemRequest;
import com.kunminx.puremusic.domain.request.Request;

import java.util.List;

/**
 * Create by KunMinX at 19/10/29
 */
public class MainActivityViewModel extends ViewModel implements Request.IGridItemRequest {

    public final ObservableBoolean initTabAndPage = new ObservableBoolean();

    public final ObservableField<String> pageAssetPath = new ObservableField<>();

    public final ObservableField<String> homeImg = new ObservableField<>();

    public final MutableLiveData<List<GridItem>> javaList = new MutableLiveData<>();
    public final MutableLiveData<List<GridItem>> kotlinList = new MutableLiveData<>();

    private GridItemRequest mGridItemRequest = new GridItemRequest();

    {
        initTabAndPage.set(true);
        pageAssetPath.set("java2kotlin.html");
        homeImg.set("https://i.loli.net/2020/06/09/rLzKlThf5pQvtCj.jpg");
    }

    @Override
    public LiveData<List<GridItem>> getJavaItemsLiveData() {
        return mGridItemRequest.getJavaItemsLiveData();
    }

    @Override
    public LiveData<List<GridItem>> getKotlinItemsLiveData() {
        return mGridItemRequest.getKotlinItemsLiveData();
    }

    @Override
    public void requestJavaItems() {
        mGridItemRequest.requestJavaItems();
    }

    @Override
    public void requestKotlinItems() {
        mGridItemRequest.requestKotlinItems();
    }
}
