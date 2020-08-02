package com.example.testtask.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtask.modelki.Post
import com.example.testtask.network.post.PostData

@Entity(tableName = "posts_table")
data class DatabasePost(
    @PrimaryKey val id: Int,
    @ColumnInfo val userId: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val body: String
)

fun List<DatabasePost>.asDomainModel():List<Post> {
    return map {
        Post(
            id = it.id,
            userId = it.userId,
            title = it.title,
            body = it.body
        )
    }
}