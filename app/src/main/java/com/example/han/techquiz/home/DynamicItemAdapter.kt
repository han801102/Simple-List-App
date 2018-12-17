package com.example.han.techquiz.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.han.techquiz.common.datamodel.BasicItem
import com.example.han.techquiz.common.datamodel.ImageItem
import com.example.han.techquiz.common.viewholder.SingleImageViewHolder
import com.example.han.techquiz.home.DynamicItemAdapter.OnAdapterItemEventListener

/**
 * [RecyclerView.Adapter]
 * currently display two different type of view [SingleImageViewHolder] and []
 * specified [OnAdapterItemEventListener].to indicate different item event
 */
class DynamicItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data = ArrayList<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.SINGLE_IMAGE ->
                SingleImageViewHolder.newInstance(LayoutInflater.from(parent.context), parent)
            else -> throw Exception("Not support view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SingleImageViewHolder -> {
                (data[position] as? ImageItem)?.let {
                    holder.bindDate(it)
                }
            }
            else -> throw Exception("Not support view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is ImageItem -> ViewType.SINGLE_IMAGE
            is BasicItem -> ViewType.BASIC
            else -> super.getItemViewType(position)
        }
    }

    override fun getItemCount(): Int = data.size

    object ViewType {
        const val BASIC = 0
        const val SINGLE_IMAGE = 1
    }

    // TODO: Implement adapter item event
    interface OnAdapterItemEventListener {
        fun onItemClick() {}
    }
}


