

package com.kunminx.architecture.bridge.callback;

import androidx.annotation.Nullable;

/**
 * Create by KunMinX at 2020/6/2
 */
public class Event<T> {

    private T content;
    private boolean hasHandled;

    public Event(T content) {
        this.content = content;
    }

    @Nullable
    T getContent() {
        if (hasHandled) {
            return null;
        }
        hasHandled = true;
        return content;
    }

    void setContentNull() {
        content = null;
    }
}
