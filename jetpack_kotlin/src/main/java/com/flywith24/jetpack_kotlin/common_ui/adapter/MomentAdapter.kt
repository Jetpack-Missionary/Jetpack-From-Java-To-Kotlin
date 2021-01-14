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
class MomentAdapter(private val onClick: (Moment) -> Unit) :
        ListAdapter<Moment, MomentAdapter.ViewHolder>(MomentDiffCallback) {

    class ViewHolder(itemView: View, val onClick: (Moment) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tv_name)
        private val tvContent = itemView.findViewById<TextView>(R.id.tv_content)
        private val tvLocation = itemView.findViewById<TextView>(R.id.tv_location)
        private val ivAvatar = itemView.findViewById<ImageView>(R.id.iv_avatar)
        private val ivPreview = itemView.findViewById<ImageView>(R.id.iv_preview)
        private var currentMoment: Moment? = null

        init {
            itemView.setOnClickListener {
                currentMoment?.let {
                    onClick(it)
                }
            }
        }

        fun bind(moment: Moment) {
            currentMoment = moment

            tvName.text = moment.username
            tvContent.text = moment.content
            tvLocation.text = moment.location
            //此处使用了扩展函数
            //扩展函数详情可参考https://www.runoob.com/kotlin/kotlin-extensions.html
            ivAvatar.loadImage(moment.userAvatar)
            ivPreview.loadImage(moment.imgUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_adapter_moment, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<Moment>?) {
        super.submitList(list) {
            submitList(if (list == null) emptyList() else ArrayList(list))
        }
    }
}