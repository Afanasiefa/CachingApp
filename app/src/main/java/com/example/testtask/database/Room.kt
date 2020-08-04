package com.example.testtask.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [DatabasePost::class, DatabaseComment::class, DatabaseUser::class], version = 1)
abstract class DatabasePostBD() : RoomDatabase() {
    abstract fun postDao(): PostDao
}


