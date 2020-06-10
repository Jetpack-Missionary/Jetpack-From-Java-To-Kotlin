

package com.kunminx.jetpack_java.sample_03_viewmodel.domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kunminx.jetpack_java.sample_03_viewmodel.data.DataRepository;
import com.kunminx.jetpack_java.common_data.bean.Moment;

import java.util.List;

/**
 * Create by KunMinX at 2020/5/30
 */
public class MomentRequest implements Request.IMomentRequest {

    private MutableLiveData<List<Moment>> mListMutableLiveData;

    @Override
    public LiveData<List<Moment>> getListMutableLiveData() {
        if (mListMutableLiveData == null) {
            mListMutableLiveData = new MutableLiveData<>();
        }
        return mListMutableLiveData;
    }

    @Override
    public void requestList() {
        DataRepository.getInstance().requestList(mListMutableLiveData);
    }
}
