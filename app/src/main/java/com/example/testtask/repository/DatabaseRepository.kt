package com.example.testtask.repository

import com.example.testtask.database.CompletePostDao
import com.example.testtask.model.database.CompletePost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val databaseCompletePost: CompletePostDao) {

    suspend fun getCompletePostWithId(id: Long): CompletePost {
        return withContext(Dispatchers.IO) {
            databaseCompletePost.getPostById(id)
        }
    }
}