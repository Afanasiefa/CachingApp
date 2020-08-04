package com.example.testtask.dagger

import android.app.Application
import androidx.room.Room
import com.example.testtask.database.CompletePosts
import com.example.testtask.database.PostDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val application: Application) {

    @Provides
    @Singleton
    fun getDatabase(): CompletePosts {
        synchronized(CompletePosts::class.java) {
            return Room.databaseBuilder(
                application.applicationContext,
                CompletePosts::class.java,
                "videos"
            ).build()
        }
    }

    @Provides
    @Singleton
    fun getDao(postsDatabase: CompletePosts): PostDao {
      return postsDatabase.postDao()
    }
}
