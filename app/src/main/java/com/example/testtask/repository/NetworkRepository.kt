package com.example.testtask.repository


import android.util.Log
import com.example.testtask.api.NetworkService
import com.example.testtask.database.CompletePostDao
import com.example.testtask.model.database.CompletePost
import com.example.testtask.model.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    val networkService: NetworkService, val databaseCompletePost: CompletePostDao
) {


    suspend fun getPosts(): List<CompletePost> {
        try {
            return withContext(Dispatchers.IO) {
                val posts = networkService.getPostFromServer()
                val comments = networkService.getCommentsFromServer()
                val user = networkService.getUsersFromServer()

                val postToDb = posts.asDatabaseModel()
                val commentToDb = comments.asDatabaseModel()
                val userToDb = user.asDatabaseModel()

                databaseCompletePost.apply {
                    insertAllPosts(postToDb)
                    insertAllComments(commentToDb)
                    insertAllUsers(userToDb)
                }
                databaseCompletePost.getAllPosts()

            }


        } catch (e: Exception) {
            Log.e("TAG", e.message)
            return emptyList()
        }
    }
}