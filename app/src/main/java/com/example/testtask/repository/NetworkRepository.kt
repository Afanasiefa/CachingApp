package com.example.testtask.repository


import android.util.Log
import com.example.testtask.database.CompletePost
import com.example.testtask.database.PostDao
import com.example.testtask.network.post.SomeApi
import com.example.testtask.network.post.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    val someApi: SomeApi, val databasePost: PostDao
) {


    suspend fun getPosts(): List<CompletePost> {
        try {
            return withContext(Dispatchers.IO) {
                val posts = someApi.getPostFromServer()
                val comments = someApi.getCommentsFromServer()
                val user = someApi.getUsersFromServer()

                val postToDb = posts.asDatabaseModel()
                val commentToDb = comments.asDatabaseModel()
                val userToDb = user.asDatabaseModel()
                databasePost.insertAllPosts(postToDb)
                databasePost.insertAllComments(commentToDb)
                databasePost.insertAllUsers(userToDb)
                databasePost.getAllPosts()

            }


        } catch (e: Exception) {
            Log.e("TAG", e.message)
            return emptyList()
        }
    }


}