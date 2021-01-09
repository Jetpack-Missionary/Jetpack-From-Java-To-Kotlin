package com.flywith24.jetpack_kotlin.common_ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.bean.LocationBean

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   11:47
 * description
 * ListAdapter 强制使用 DiffUtil 比较数据变化，开发者无需手动调用各种 notify 方法亦可使用 recyclerView 的动画
 */
class LocationAdapter(private val onClick: (LocationBean) -> Unit) :
        ListAdapter<LocationBean, LocationAdapter.ViewHolder>(LocationDiffCallback) {

    class ViewHolder(itemView: View, val onClick: (LocationBean) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private var mTvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private var currentLocation: LocationBean? = null

        init {
            itemView.setOnClickListener {
                currentLocation?.let {
                    onClick(it)
                }
            }
        }

        fun bind(item: LocationBean) {
            currentLocation = item
            mTvTitle.text = item.locationName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_adapter_location, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<LocationBean>?) {
        super.submitList(list) {
            submitList(if (list == null) emptyList() else ArrayList(list))
        }
    }
}

