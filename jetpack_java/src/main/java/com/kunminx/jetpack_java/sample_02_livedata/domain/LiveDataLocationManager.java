

package com.kunminx.jetpack_java.sample_02_livedata.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kunminx.jetpack_java.common_data.bean.LocationBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create by KunMinX at 2020/5/30
 */
public class LiveDataLocationManager implements DefaultLifecycleObserver {

    private static LiveDataLocationManager sManager = new LiveDataLocationManager();

    private Timer mTimer;

    public static LiveDataLocationManager getInstance() {
        return sManager;
    }

    private LiveDataLocationManager() {
    }

    private MutableLiveData<List<LocationBean>> mLocationBeans = new MutableLiveData<>();

    private List<LocationBean> mList = new ArrayList<>();

    public LiveData<List<LocationBean>> getLocationBeans() {
        return mLocationBeans;
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        //TODO 我是获取附近位置列表信息的后台定位服务，我耗电巨大，我随着页面的 onResume 开启了

        mTimer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                //模拟定位，假设开启了 GPS 并且每秒获取若干条新的位置信息

                mList.add(new LocationBean("台北夜市 " + System.currentTimeMillis() + " 号"));
                mLocationBeans.postValue(mList);

                onResume(owner);
            }
        };

        mTimer.schedule(task, 250);

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        //TODO 定位服务随着页面的 onPause 而关闭了

        mTimer.cancel();
        mTimer = null;

        mList.clear();
    }
}
