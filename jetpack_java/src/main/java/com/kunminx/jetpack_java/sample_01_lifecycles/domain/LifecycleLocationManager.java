

package com.kunminx.jetpack_java.sample_01_lifecycles.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.kunminx.jetpack_java.common_data.bean.LocationBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create by KunMinX at 2020/5/30
 */
public class LifecycleLocationManager implements DefaultLifecycleObserver {

    private static LifecycleLocationManager sManager = new LifecycleLocationManager();

    private Timer mTimer;

    public static LifecycleLocationManager getInstance() {
        return sManager;
    }

    private LifecycleLocationManager() {
    }

    private List<LocationBean> mLocationBeans = new ArrayList<>();
    private ILocationCallback mILocationCallback;

    public void setILocationCallback(ILocationCallback ILocationCallback) {
        mILocationCallback = ILocationCallback;
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        //TODO 我是获取附近位置列表信息的后台定位服务，我耗电巨大，我随着页面的 onResume 开启了

        mTimer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                //模拟定位，假设开启了 GPS 并且每秒获取若干条新的位置信息

                mLocationBeans.add(new LocationBean("台北夜市 " + System.currentTimeMillis() + " 号"));

                if (mILocationCallback != null) {
                    mILocationCallback.onListChanged(mLocationBeans);
                }

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

        mLocationBeans.clear();
    }

    public interface ILocationCallback {
        void onListChanged(List<LocationBean> list);
    }
}
