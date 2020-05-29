package com.kunminx.puremusic.domain.request;

import androidx.lifecycle.LiveData;

import com.kunminx.puremusic.data.bean.GridItem;

import java.util.List;

/**
 * Create by KunMinX at 2020/5/21
 */
public class Request {

    public interface IGridItemRequest {

        LiveData<List<GridItem>> getJavaItemsLiveData();

        LiveData<List<GridItem>> getKotlinItemsLiveData();

        void requestJavaItems();

        void requestKotlinItems();
    }
}
