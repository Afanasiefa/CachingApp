package com.example.testtask.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtask.model.database.DatabaseComment
import com.example.testtask.model.database.DatabasePost
import com.example.testtask.model.database.DatabaseUser


@Database(entities = [DatabasePost::class, DatabaseComment::class, DatabaseUser::class], version = 1)
abstract class DatabasePostBD() : RoomDatabase() {
    abstract fun postDao(): CompletePostDao
}


