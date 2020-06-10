

package com.kunminx.jetpack_java.sample_04_databinding.ui.state;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.kunminx.jetpack_java.common_data.APIs;

/**
 * Create by KunMinX at 2020/5/30
 */
public class EditorViewModel extends ViewModel {

    public final ObservableField<String> imgUrl = new ObservableField<>();
    public final ObservableField<String> content = new ObservableField<>();
    public final ObservableField<String> location = new ObservableField<>();

    {
        location.set("添加定位");
        content.set("");
        imgUrl.set(APIs.ADD_PIC_TIP_URL);
    }
}
