package com.example.testtask.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.databinding.PostItemBinding
import com.example.testtask.model.database.CompletePost


class PostsListAdapter(private val postClickListener: PostClickListener) :
    ListAdapter<CompletePost, PostsListAdapter.PostsListViewHolder>(PostDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsListViewHolder {
        return PostsListViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PostsListViewHolder, position: Int) {
        val item = getItem(position)

        holder.itemView.setOnClickListener {
            postClickListener.onClick(item)
        }

        holder.bind(item)
    }

    class PostClickListener(val click: (post: CompletePost) -> Unit) {
        fun onClick(post: CompletePost): Unit = click(post)

    }

    class PostDiffUtils : DiffUtil.ItemCallback<CompletePost>() {

        override fun areItemsTheSame(oldItem: CompletePost, newItem: CompletePost): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CompletePost, newItem: CompletePost): Boolean {
            return oldItem.post.postId == newItem.post.postId
        }

    }

    class PostsListViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: CompletePost) {
            binding.postItemUsrName.text = post.user.username
            binding.postItemTitle.text = post.post.title
            binding.postItemCommentsNum.text = StringBuilder()
                .append(post.comments.size.toString())
                .append(" ")
                .append("comments")
        }
    }
}

