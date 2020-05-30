package com.example.jetpack_kotlin.sample_01_lifecycles.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_koltin.R
import com.example.jetpack_kotlin.sample_01_lifecycles.data.bean.LocationBean

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   11:47
 * description
 * ListAdapter 强制使用 DiffUtil 比较数据变化，开发者无需手动调用各种 notify 方法亦可使用 recyclerView 的动画
 */
class LocationAdapter(private val listener: OnItemClickListener) : ListAdapter<LocationBean, LocationAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_location, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClick(getItem(position))
        }
        holder.bind(getItem(position))
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

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<LocationBean>() {
            override fun areItemsTheSame(oldItem: LocationBean, newItem: LocationBean): Boolean =
                    oldItem.locationName == newItem.locationName


            override fun areContentsTheSame(oldItem: LocationBean, newItem: LocationBean): Boolean =
                    oldItem.locationName == newItem.locationName

        }
    }
}

