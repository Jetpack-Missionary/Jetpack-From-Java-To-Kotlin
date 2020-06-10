

package com.kunminx.jetpack_java.sample_04_databinding.ui.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kunminx.jetpack_java.common_data.bean.LocationBean;

import java.util.List;

/**
 * Create by KunMinX at 2020/5/30
 */
public class LocationViewModel extends ViewModel {

    public final MutableLiveData<List<LocationBean>> list = new MutableLiveData<>();


}
