package com.example.testtask.dagger

import android.app.Application
import androidx.room.Room

import com.example.testtask.database.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val application: Application) {

    @Provides
    @Singleton

    fun getDatabasePosts(): DatabasePostBD {
        synchronized(DatabasePostBD::class.java) {
            return Room.databaseBuilder(
                application.applicationContext,
                DatabasePostBD::class.java,
                "post"
            ).build()
        }
    }

    @Provides
    @Singleton
    fun getDaoPosts(postsDatabase: DatabasePostBD): PostDao {
        return postsDatabase.postDao()
    }


}