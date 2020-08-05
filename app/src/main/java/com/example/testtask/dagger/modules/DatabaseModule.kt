package com.example.testtask.dagger.modules

import android.app.Application
import androidx.room.Room
import com.example.testtask.database.*
import com.example.testtask.repository.DatabaseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: Application) {

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
    fun getDaoPosts(postsDatabase: DatabasePostBD): CompletePostDao {
        return postsDatabase.postDao()
    }

    @Provides
    @Singleton
    fun getDatabaseRepository(dao: CompletePostDao): DatabaseRepository {
        return DatabaseRepository(dao)
    }
}