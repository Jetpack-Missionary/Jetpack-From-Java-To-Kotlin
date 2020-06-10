

package com.kunminx.jetpack_java.sample_04_databinding.ui.state;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.kunminx.jetpack_java.common_data.bean.Moment;

/**
 * Create by KunMinX at 2020/5/30
 */
public class DetailViewModel extends ViewModel {

    public final ObservableField<String> imgUrl = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> content = new ObservableField<>();
    public final ObservableField<String> location = new ObservableField<>();
    public final ObservableField<String> avatar = new ObservableField<>();

    public void initState(Moment moment) {
        avatar.set(moment.getUserAvatar());
        name.set(moment.getUserName());
        content.set(moment.getContent());
        imgUrl.set(moment.getImgUrl());
        location.set(moment.getLocation());
    }
}
