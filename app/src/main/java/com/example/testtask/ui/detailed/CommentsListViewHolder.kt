package com.example.testtask.ui.detailed

import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.databinding.CommentItemBinding
import com.example.testtask.model.database.DatabaseComment

class CommentsListViewHolder(private val binding: CommentItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(comment: DatabaseComment) {
        binding.commentBody.text = comment.body
        binding.commentAuthorEmail.text = comment.email
    }
}