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

package com.example.jetpack_java.lifecycles.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * Create by KunMinX at 2020/5/30
 */
public class LocationManager implements DefaultLifecycleObserver {

    private static LocationManager sManager = new LocationManager();

    public static LocationManager newInstance() {
        return sManager;
    }

    private LocationManager() {
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        //TODO 我是获取附近位置列表信息的后台定位服务，我耗电巨大，我随着页面的 onResume 开启了

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        //TODO 我随着页面的 onPause 而关闭了

    }
}
