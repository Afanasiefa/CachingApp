package com.example.testtask.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.databinding.PostItemBinding
import com.example.testtask.modelki.Post
import com.example.testtask.network.post.PostData

class PostsListAdapter(val postClickListener: PostClickListener) :
    ListAdapter<Post, PostsListAdapter.PostViewHolder>(PostDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = getItem(position)

        holder.itemView.setOnClickListener {
            postClickListener.onClick(item)
        }

        holder.bind(item)
    }

    class PostClickListener(val click: (post: Post) -> Unit) {
        fun onClick(post: Post): Unit = click(post)

    }

    class PostDiffUtils() : DiffUtil.ItemCallback<Post>() {

        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class PostViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.postItemTitle.text = post.title
        }
    }
}

