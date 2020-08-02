package com.example.testtask.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos: List<DatabasePost>)

    @Query("SELECT * FROM posts_table ORDER BY id DESC")
    fun getAllPosts(): LiveData<List<DatabasePost>>

}