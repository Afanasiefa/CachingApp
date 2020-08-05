package com.example.testtask.model.database

import androidx.room.Embedded
import androidx.room.Relation

data class CompletePost(
    @Embedded val post: DatabasePost,
    @Relation(parentColumn = "userId", entityColumn = "userId")
    var user: DatabaseUser,
    @Relation(parentColumn = "postId", entityColumn = "postId")
    var comments: List<DatabaseComment>
)