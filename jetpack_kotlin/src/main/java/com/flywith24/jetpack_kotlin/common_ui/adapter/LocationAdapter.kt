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
class LocationAdapter(private val listener: OnItemClickListener) : ListAdapter<LocationBean, LocationAdapter.ViewHolder>(locationDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.kotlin_adapter_location, parent, false))
        // setOnClickListener 在此处调用，如果在 onBindViewHolder 中调用会执行多次
        holder.itemView.setOnClickListener {
            listener.onItemClick(getItem(holder.bindingAdapterPosition))
        }
        return holder
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<LocationBean>?) {
        super.submitList(list) {
            submitList(if (list == null) emptyList() else ArrayList(list))
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var mTvTitle: TextView = itemView.findViewById(R.id.tv_title)

        fun bind(item: LocationBean) {
            mTvTitle.text = item.locationName
        }
    }

    interface OnItemClickListener {
        fun onItemClick(locationBean: LocationBean)
    }
}

