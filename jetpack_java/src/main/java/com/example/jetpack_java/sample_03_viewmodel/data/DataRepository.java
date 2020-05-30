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

package com.example.jetpack_java.sample_03_viewmodel.data;

import androidx.lifecycle.MutableLiveData;

import com.example.jetpack_java.common_data.APIs;
import com.example.jetpack_java.common_data.bean.Moment;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by KunMinX at 2020/5/30
 */
public class DataRepository {

    private static DataRepository sRepository = new DataRepository();

    public static DataRepository getInstance() {
        return sRepository;
    }

    private DataRepository() {
    }

    public void requestList(MutableLiveData<List<Moment>> liveData) {
        List<Moment> list = new ArrayList<>();

        list.add(new Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                "台北夜市一条街", APIs.PIC_URL, "KunMinX", APIs.PIC_URL));

        list.add(new Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                "台北夜市一条街", APIs.PIC_URL, "KunMinX", APIs.PIC_URL));

        list.add(new Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                "台北夜市一条街", APIs.PIC_URL, "KunMinX", APIs.PIC_URL));

        list.add(new Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                "台北夜市一条街", APIs.PIC_URL, "KunMinX", APIs.PIC_URL));

        list.add(new Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                "台北夜市一条街", APIs.PIC_URL, "KunMinX", APIs.PIC_URL));

        list.add(new Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                "台北夜市一条街", APIs.PIC_URL, "KunMinX", APIs.PIC_URL));

        list.add(new Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                "台北夜市一条街", APIs.PIC_URL, "KunMinX", APIs.PIC_URL));

        list.add(new Moment("刚刚在B站发表了最新一期的视频讲解，感兴趣的小伙伴可前往查阅",
                "台北夜市一条街", APIs.PIC_URL, "KunMinX", APIs.PIC_URL));

        liveData.setValue(list);
    }

}
