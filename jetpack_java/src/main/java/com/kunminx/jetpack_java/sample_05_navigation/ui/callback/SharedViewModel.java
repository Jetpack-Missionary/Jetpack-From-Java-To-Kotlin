

package com.kunminx.jetpack_java.sample_05_navigation.ui.callback;

import androidx.lifecycle.ViewModel;

import com.kunminx.architecture.bridge.callback.EventLiveData;
import com.kunminx.jetpack_java.common_data.bean.Moment;

/**
 * Create by KunMinX at 2020/5/30
 */
public class SharedViewModel extends ViewModel {

    public final EventLiveData<String> location = new EventLiveData<>();
    public final EventLiveData<Moment> moment = new EventLiveData<>();
    public final EventLiveData<Boolean> closeActivity = new EventLiveData<>();

}
