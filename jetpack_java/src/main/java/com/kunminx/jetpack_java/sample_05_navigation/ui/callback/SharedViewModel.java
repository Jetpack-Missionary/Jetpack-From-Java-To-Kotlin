

package com.kunminx.jetpack_java.sample_05_navigation.ui.callback;

import androidx.lifecycle.ViewModel;

import com.kunminx.architecture.ui.callback.ProtectedUnPeekLiveData;
import com.kunminx.architecture.ui.callback.UnPeekLiveData;
import com.kunminx.jetpack_java.common_data.bean.Moment;

/**
 * TODO：本示例专注于提供 Navigation 组件的使用场景和示例，因而其他内容均保持 Android 引入 Jetpack 前的模样，
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
public class SharedViewModel extends ViewModel {

    private UnPeekLiveData<String> location;
    private UnPeekLiveData<Moment> moment;
    private UnPeekLiveData<Boolean> closeActivity;

    public ProtectedUnPeekLiveData<String> getLocation() {
        if (location == null) location = new UnPeekLiveData<>();
        return location;
    }

    public ProtectedUnPeekLiveData<Moment> getMoment() {
        if (moment == null) moment = new UnPeekLiveData<>();
        return moment;
    }

    public ProtectedUnPeekLiveData<Boolean> getCloseActivity() {
        if (closeActivity == null) closeActivity = new UnPeekLiveData<>();
        return closeActivity;
    }

    public void requestAddMoment(Moment moment) {
        this.moment.setValue(moment);
    }

    public void requestCloseActivity() {
        this.closeActivity.setValue(true);
    }

    public void requestAddLocation(String locationName) {
        this.location.setValue(locationName);
    }
}
