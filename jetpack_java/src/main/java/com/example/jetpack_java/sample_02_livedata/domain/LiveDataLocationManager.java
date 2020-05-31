/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetpack_java.sample_02_livedata.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jetpack_java.common_data.bean.LocationBean;

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
    private List<LocationBean> mNewList;

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
                mNewList = new ArrayList<>(mList);
                mLocationBeans.postValue(mNewList);

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
