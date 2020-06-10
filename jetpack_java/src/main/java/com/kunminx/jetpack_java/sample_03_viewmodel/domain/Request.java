

package com.kunminx.jetpack_java.sample_03_viewmodel.domain;

import androidx.lifecycle.LiveData;

import com.kunminx.jetpack_java.common_data.bean.Moment;

import java.util.List;

/**
 * Create by KunMinX at 2020/5/30
 */
public class Request {

    public interface IMomentRequest {

        LiveData<List<Moment>> getListMutableLiveData();

        void requestList();
    }
}
