package com.example.testtask.database

import androidx.room.*
import com.example.testtask.model.database.CompletePost
import com.example.testtask.model.database.DatabaseComment
import com.example.testtask.model.database.DatabasePost
import com.example.testtask.model.database.DatabaseUser

@Dao
interface CompletePostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPosts(post: List<DatabasePost>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllComments(comments: List<DatabaseComment>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(users: List<DatabaseUser>)

    @Transaction
    @Query("SELECT * FROM posts_table")
    fun getAllPosts(): List<CompletePost>

    @Transaction
    @Query("SELECT * FROM posts_table WHERE postId = :id")
    fun getPostById(id: Long): CompletePost
}