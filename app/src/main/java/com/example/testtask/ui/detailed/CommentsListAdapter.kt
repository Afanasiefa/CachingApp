package com.example.testtask.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.database.DatabaseComment
import com.example.testtask.databinding.CommentItemBinding


class CommentsListAdapter() :
    ListAdapter<DatabaseComment, CommentsListAdapter.CommentViewHolder>(CommentDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(CommentItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }


    class CommentDiffUtils() : DiffUtil.ItemCallback<DatabaseComment>() {

        override fun areItemsTheSame(oldItem: DatabaseComment, newItem: DatabaseComment): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: DatabaseComment,
            newItem: DatabaseComment
        ): Boolean {
            return oldItem.commentId == newItem.commentId
        }

    }

    class CommentViewHolder(private val binding: CommentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: DatabaseComment) {
            binding.commentBody.text = comment.body
            binding.commentAuthorEmail.text = comment.email
        }
    }
}

