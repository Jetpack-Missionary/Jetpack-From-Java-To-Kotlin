

package com.kunminx.jetpack_java.sample_03_viewmodel.data;

import androidx.lifecycle.MutableLiveData;

import com.kunminx.jetpack_java.common_data.APIs;
import com.kunminx.jetpack_java.common_data.bean.Moment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TODO：本示例专注于提供 ViewModel 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
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
public class DataRepository {

    private static DataRepository sRepository = new DataRepository();

    public static DataRepository getInstance() {
        return sRepository;
    }

    private DataRepository() {
    }

    public void requestList(MutableLiveData<List<Moment>> liveData) {
        List<Moment> list = new ArrayList<>();

        list.add(new Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                "重庆朝天门码头", APIs.SCENE_URL, "KunMinX", APIs.KUNMINX_URL));

        list.add(new Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                "重庆朝天门码头", APIs.SCENE_URL, "Flywith24", APIs.FLYWITH24_URL));

        list.add(new Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                "重庆朝天门码头", APIs.SCENE_URL, "KunMinX", APIs.KUNMINX_URL));

        list.add(new Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                "重庆朝天门码头", APIs.SCENE_URL, "Flywith24", APIs.FLYWITH24_URL));

        list.add(new Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                "重庆朝天门码头", APIs.SCENE_URL, "KunMinX", APIs.KUNMINX_URL));

        list.add(new Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                "重庆朝天门码头", APIs.SCENE_URL, "Flywith24", APIs.FLYWITH24_URL));

        list.add(new Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                "重庆朝天门码头", APIs.SCENE_URL, "KunMinX", APIs.KUNMINX_URL));

        list.add(new Moment(getUUID(), "刚刚在掘金发表了最新一期动态，感兴趣的小伙伴可前往查阅",
                "重庆朝天门码头", APIs.SCENE_URL, "Flywith24", APIs.FLYWITH24_URL));

        liveData.setValue(list);
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
