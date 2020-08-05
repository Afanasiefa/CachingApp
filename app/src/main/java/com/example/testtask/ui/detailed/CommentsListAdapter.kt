package com.example.testtask.ui.detailed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.testtask.databinding.CommentItemBinding
import com.example.testtask.model.database.DatabaseComment

class CommentsListAdapter :
    ListAdapter<DatabaseComment, CommentsListViewHolder>(CommentDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsListViewHolder {
        return CommentsListViewHolder(CommentItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CommentsListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class CommentDiffUtils : DiffUtil.ItemCallback<DatabaseComment>() {

        override fun areItemsTheSame(oldItem: DatabaseComment, newItem: DatabaseComment): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DatabaseComment, newItem: DatabaseComment): Boolean {
            return oldItem.commentId == newItem.commentId
        }

    }
}

