

package com.kunminx.puremusic.domain.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kunminx.puremusic.data.bean.GridItem;
import com.kunminx.puremusic.data.repository.DataRepository;

import java.util.List;

/**
 * 音乐资源  Request
 * <p>
 * TODO tip：Request 通常按业务划分
 * 一个项目中通常存在多个 Request
 * <p>
 * request 的职责仅限于 数据请求，不建议在此处理 UI 逻辑，
 * UI 逻辑只适合在 Activity/Fragment 等视图控制器中完成，是 “数据驱动” 的一部分，
 * 将来升级到 Jetpack Compose 更是如此。
 * <p>
 * 如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/6257931840
 * <p>
 * Create by KunMinX at 19/10/29
 */
public class GridItemRequest implements Request.IGridItemRequest {

    private MutableLiveData<List<GridItem>> mJavaItemsLiveData;
    private MutableLiveData<List<GridItem>> mKotlinItemsLiveData;

    //TODO tip 向 ui 层提供的 request LiveData，使用抽象的 LiveData 而不是 MutableLiveData
    // 如此是为了来自数据层的数据，在 ui 层中只读，以避免团队新手不可预期的误用

    @Override
    public LiveData<List<GridItem>> getJavaItemsLiveData() {
        if (mJavaItemsLiveData == null) {
            mJavaItemsLiveData = new MutableLiveData<>();
        }
        return mJavaItemsLiveData;
    }

    @Override
    public LiveData<List<GridItem>> getKotlinItemsLiveData() {
        if (mKotlinItemsLiveData == null) {
            mKotlinItemsLiveData = new MutableLiveData<>();
        }
        return mKotlinItemsLiveData;
    }

    @Override
    public void requestJavaItems() {
        DataRepository.getInstance().getJavaItems(mJavaItemsLiveData);
    }

    @Override
    public void requestKotlinItems() {
        DataRepository.getInstance().getKotlinItems(mKotlinItemsLiveData);
    }
}
