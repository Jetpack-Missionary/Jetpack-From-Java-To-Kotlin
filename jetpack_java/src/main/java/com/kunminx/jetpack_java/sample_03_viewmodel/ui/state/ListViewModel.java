

package com.kunminx.jetpack_java.sample_03_viewmodel.ui.state;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kunminx.jetpack_java.common_data.bean.Moment;
import com.kunminx.jetpack_java.sample_03_viewmodel.domain.MomentRequest;
import com.kunminx.jetpack_java.sample_03_viewmodel.domain.Request;

import java.util.List;

/**
 * Create by KunMinX at 2020/5/30
 */
public class ListViewModel extends ViewModel implements Request.IMomentRequest {

    private MomentRequest mMomentRequest = new MomentRequest();

    @Override
    public LiveData<List<Moment>> getListMutableLiveData() {
        return mMomentRequest.getListMutableLiveData();
    }

    @Override
    public void requestList() {
        mMomentRequest.requestList();
    }
}
