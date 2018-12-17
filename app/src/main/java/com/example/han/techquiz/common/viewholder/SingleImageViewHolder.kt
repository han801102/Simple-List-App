package com.example.han.techquiz.common.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.han.techquiz.GlideApp
import com.example.han.techquiz.R
import com.example.han.techquiz.common.datamodel.ImageItem

/**
 * A ViewHolder with only a image
 */
class SingleImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView: ImageView? = itemView.findViewById(R.id.image_view)

    fun bindDate(imageItem: ImageItem) {
        imageView?.let {
            GlideApp.with(itemView)
                .load(imageItem.imageUrl)
                .fitCenter()
                .into(it)
        }
    }

    companion object {
        fun newInstance(inflater: LayoutInflater, parent: ViewGroup) =
            SingleImageViewHolder(inflater.inflate(R.layout.item_image, parent, false))
    }
}