package com.example.testtask.model.database

import androidx.room.*

@Entity(tableName = "posts_table")
data class DatabasePost(
    @PrimaryKey val postId: Long,
    @ColumnInfo val userId: Long,
    @ColumnInfo val title: String,
    @ColumnInfo val body: String
)


