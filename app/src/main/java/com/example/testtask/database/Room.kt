package com.example.testtask.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DatabasePost::class], version = 1)
abstract class PostsDatabase() : RoomDatabase() {
    abstract fun postDao(): PostDao
}



