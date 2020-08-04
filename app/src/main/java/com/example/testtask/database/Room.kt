package com.example.testtask.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CompletePost::class], version = 1)
abstract class CompletePosts() : RoomDatabase() {
    abstract fun postDao(): PostDao
}



