package com.kunminx.architecture.kotlin

import androidx.lifecycle.ViewModelStore

/**
 * @author Flywith24
 * @date   2020/6/4
 * time   21:10
 * description
 * 使用 包装类 解决 LiveData 粘性事件的问题
 * 详见 https://juejin.im/post/5b2b1b2cf265da5952314b63
 */
open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    private var map = HashMap<ViewModelStore, Boolean>()

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * 根据同观察者判断事件是否消费
     * 如果该观察者已消费数据，则返回null
     * 否则标记已消费并返回数据
     */
    fun getContentIfNotHandled(viewModelStore: ViewModelStore): T? {
        return if (map.contains(viewModelStore)) {
            null
        } else {
            map[viewModelStore] = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}