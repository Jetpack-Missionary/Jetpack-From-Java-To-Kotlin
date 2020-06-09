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
