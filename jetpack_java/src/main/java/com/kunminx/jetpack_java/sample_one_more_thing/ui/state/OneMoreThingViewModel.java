

package com.kunminx.jetpack_java.sample_one_more_thing.ui.state;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * Create by KunMinX at 2020/6/1
 */
public class OneMoreThingViewModel extends ViewModel {

    public final ObservableField<String> pageAssetPath = new ObservableField<>();

    {
        pageAssetPath.set("best_practice.html");
    }
}
