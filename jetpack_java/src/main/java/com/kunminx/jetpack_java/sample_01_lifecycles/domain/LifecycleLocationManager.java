

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
 * TODO：本示例专注于提供 Lifecycle 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
 * kotlin 模块提供同样的场景和基于 Kotlin 的写法，可对照查阅。
 * 并且本项目的示例从 sample_01 到 sample_05 是循序渐进地 Jetpack 化，
 * 如看完对 Jetpack 高频核心组件 "为什么要用"、"为什么要这样用" 有了一丝丝好奇心，可前往《Jetpack MVVM 精讲》和《Jetpack MVVM 最佳实践》项目查阅深度解析。
 * <p>
 * https://juejin.im/post/5dafc49b6fb9a04e17209922
 * <p>
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 * <p>
 * <p>
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

        mTimer.schedule(task, 200);

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
