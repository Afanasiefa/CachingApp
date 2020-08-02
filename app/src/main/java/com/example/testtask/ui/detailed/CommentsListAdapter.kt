package com.example.testtask.ui.detailed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.databinding.PostItemBinding
import com.example.testtask.network.post.PostData

class CommentsListAdapter : ListAdapter<PostData, CommentsListAdapter.PostViewHolder>(CommentDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class CommentDiffUtils() : DiffUtil.ItemCallback<PostData>() {

        override fun areItemsTheSame(oldItem: PostData, newItem: PostData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PostData, newItem: PostData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class PostViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: PostData) {
            binding.postItemTitle.text = post.title
        }
    }
}
