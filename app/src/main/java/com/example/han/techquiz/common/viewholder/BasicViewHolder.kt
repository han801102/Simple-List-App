package com.example.han.techquiz.common.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.han.techquiz.GlideApp
import com.example.han.techquiz.R
import com.example.han.techquiz.common.datamodel.BasicItem

/**
 * A basic ViewHolder with title, subtitle, image
 */
class BasicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView: ImageView? = itemView.findViewById(R.id.image_view)
    private val viewTitle: TextView? = itemView.findViewById(R.id.view_title)
    private val viewSubtitle: TextView? = itemView.findViewById(R.id.view_subtitle)

    fun bindDate(basicItem: BasicItem) {
        viewTitle?.text = basicItem.title
        viewSubtitle?.text = basicItem.description
        imageView?.let {
            GlideApp.with(itemView)
                .load(basicItem.imageUrl)
                .fitCenter()
                .into(it)
        }
    }

    companion object {
        fun newInstance(inflater: LayoutInflater, parent: ViewGroup) =
            BasicViewHolder(inflater.inflate(R.layout.item_basic, parent, false))
    }
}