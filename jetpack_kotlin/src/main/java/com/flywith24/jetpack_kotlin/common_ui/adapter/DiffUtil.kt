package com.flywith24.jetpack_kotlin.common_ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.flywith24.jetpack_kotlin.common_data.bean.LocationBean
import com.flywith24.jetpack_kotlin.common_data.bean.Moment

/**
 * @author Flywith24
 * @date   2020/5/31
 * time   23:00
 * description
 */
object LocationDiffCallback : DiffUtil.ItemCallback<LocationBean>() {
    override fun areItemsTheSame(oldItem: LocationBean, newItem: LocationBean): Boolean =
            oldItem == newItem


    override fun areContentsTheSame(oldItem: LocationBean, newItem: LocationBean): Boolean =
            oldItem.locationName == newItem.locationName
}

object MomentDiffCallback : DiffUtil.ItemCallback<Moment>() {
    override fun areItemsTheSame(oldItem: Moment, newItem: Moment): Boolean {
        return oldItem.uuid == newItem.uuid
    }

    override fun areContentsTheSame(oldItem: Moment, newItem: Moment): Boolean {
        return oldItem.content == newItem.content &&
                oldItem.imgUrl == newItem.imgUrl &&
                oldItem.location == newItem.location &&
                oldItem.username == newItem.username &&
                oldItem.userAvatar == newItem.userAvatar
    }
}