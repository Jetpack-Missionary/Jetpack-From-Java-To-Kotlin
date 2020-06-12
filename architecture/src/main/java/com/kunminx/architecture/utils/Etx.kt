package com.kunminx.architecture.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:53
 * description
 * 扩展函数
 */

fun ImageView.loadImage(url: String) {
    Glide.with(context)
            .load(url)
            .into(this)
}