

package com.kunminx.puremusic.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.kunminx.puremusic.data.bean.GridItem;

import java.util.List;

/**
 * Create by KunMinX at 19/10/29
 */
public interface IRemoteRequest {

    void getJavaItems(MutableLiveData<List<GridItem>> liveData);

    void getKotlinItems(MutableLiveData<List<GridItem>> liveData);

}
