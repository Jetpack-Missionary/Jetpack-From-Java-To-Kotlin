package com.flywith24.jetpack_kotlin.sample_05_navigation.ui.callback

import androidx.lifecycle.ViewModel
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.kunminx.architecture.kotlin.EventMutableLiveData

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   21:54
 * description
 */
class SharedViewModel : ViewModel() {
    /**
     * 使用 包装类 解决 LiveData 粘性事件的问题
     * 详见
     * https://juejin.im/post/5ed9c92ce51d45789b35afa9 (kotlin 扩展函数和 typealias 封装 LiveData)
     *
     * https://juejin.im/post/5b2b1b2cf265da5952314b63 (粘性事件)
     */
    val location = EventMutableLiveData<String>()
    val moment = EventMutableLiveData<Moment>()
    val closeActivity = EventMutableLiveData<Boolean>()

}