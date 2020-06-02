package com.kunminx.architecture.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.kunminx.architecture.BaseApplication

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:53
 * description
 * 扩展函数
 */

fun ImageView.loadImage(url: String?) {
    Glide.with(BaseApplication.instance.applicationContext)
            .load(url)
            .into(this)
}