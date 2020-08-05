package com.example.testtask.model.database

import androidx.room.*

@Entity(tableName = "posts_table")
data class DatabasePost(
    @PrimaryKey val postId: Int,
    @ColumnInfo val userId: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val body: String
)


