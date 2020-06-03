package com.flywith24.jetpack_kotlin.sample_05_navigation.ui.callback

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.kunminx.architecture.bridge.callback.Event

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   21:54
 * description
 */
class SharedViewModel : ViewModel() {
    /**
     * 使用 包装类 解决 LiveData 粘性事件的问题
     * 详见 https://juejin.im/post/5b2b1b2cf265da5952314b63
     */
    val location = MutableLiveData<Event<String>>()
    val moment = MutableLiveData<Event<Moment>>()

}