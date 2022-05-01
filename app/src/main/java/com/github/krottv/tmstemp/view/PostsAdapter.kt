package com.github.krottv.tmstemp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.github.krottv.tmstemp.R
import com.github.krottv.tmstemp.domain.PostModel

class PostsAdapter(data: List<PostModel>, private val onItemClick: (View, PostModel) -> Unit) :
    RecyclerView.Adapter<PostViewHolder>() {
    var data: MutableList<PostModel> = data as MutableList<PostModel>

    fun removeFirstItem() {
        data.removeAt(0)
        notifyItemRemoved(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = data[position]
        holder.image1.load(item.image)
        holder.textView1.text = item.title
        holder.textView2.text = item.subtitle

        holder.itemView.setOnClickListener {
            onItemClick(it, item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}