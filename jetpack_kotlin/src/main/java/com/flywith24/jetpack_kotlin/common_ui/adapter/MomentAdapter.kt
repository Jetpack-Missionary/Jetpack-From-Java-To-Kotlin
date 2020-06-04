package com.flywith24.jetpack_kotlin.common_ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.kunminx.architecture.utils.loadImage

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:31
 * description
 * ListAdapter 强制使用 DiffUtil 比较数据变化，开发者无需手动调用各种 notify 方法亦可使用 recyclerView 的动画
 */
class MomentAdapter(private val listener: OnItemClickListener) : ListAdapter<Moment, MomentAdapter.ViewHolder>(momentDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.kotlin_adapter_moment, parent, false))
        // setOnClickListener 在此处调用，如果在 onBindViewHolder 中调用会执行多次
        holder.itemView.setOnClickListener {
            listener.onItemClick(getItem(holder.bindingAdapterPosition))
        }
        return holder
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<Moment>?) {
        super.submitList(list) {
            submitList(if (list == null) emptyList() else ArrayList(list))
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tv_name)
        private val tvContent = itemView.findViewById<TextView>(R.id.tv_content)
        private val tvLocation = itemView.findViewById<TextView>(R.id.tv_location)
        private val ivAvatar = itemView.findViewById<ImageView>(R.id.iv_avatar)
        private val ivPreview = itemView.findViewById<ImageView>(R.id.iv_preview)

        fun bind(item: Moment) {
            tvName.text = item.username
            tvContent.text = item.content
            tvLocation.text = item.location
            //此处使用了扩展函数
            //扩展函数详情可参考https://www.runoob.com/kotlin/kotlin-extensions.html
            ivAvatar.loadImage(item.userAvatar)
            ivPreview.loadImage(item.imgUrl)
        }

    }

    interface OnItemClickListener {
        fun onItemClick(moment: Moment)
    }

}