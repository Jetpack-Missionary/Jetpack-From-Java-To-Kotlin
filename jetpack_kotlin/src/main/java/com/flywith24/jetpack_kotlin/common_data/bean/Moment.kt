package com.flywith24.jetpack_kotlin.common_data.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:02
 * description
 */
@Parcelize
data class Moment(
        var uuid: String,
        val content: String?,
        val location: String?,
        val imgUrl: String,
        var username: String,
        var userAvatar: String
) : Parcelable