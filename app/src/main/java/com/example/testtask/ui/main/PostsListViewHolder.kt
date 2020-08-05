package com.example.testtask.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.databinding.PostItemBinding
import com.example.testtask.model.database.CompletePost

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