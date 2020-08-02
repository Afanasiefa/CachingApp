package com.example.testtask.dagger

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.testtask.database.PostDao
import com.example.testtask.database.PostsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val application: Application) {

    @Provides
    @Singleton
    fun getDatabase(): PostsDatabase {
        synchronized(PostsDatabase::class.java) {
            return Room.databaseBuilder(
                application.applicationContext,
                PostsDatabase::class.java,
                "videos"
            ).build()
        }
    }

    @Provides
    @Singleton
    fun getDao(postsDatabase: PostsDatabase): PostDao {
      return postsDatabase.postDao()
    }
}
