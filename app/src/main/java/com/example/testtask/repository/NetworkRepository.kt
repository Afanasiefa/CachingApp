package com.example.testtask.repository

import com.example.testtask.database.*
import com.example.testtask.network.post.SomeApi
import com.example.testtask.network.post.asDatabaseComment
import com.example.testtask.network.post.asDatabasePost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkRepository @Inject constructor(val someApi: SomeApi, val databasePost: PostDao) {

    suspend fun getPosts(): List<CompletePost> {
        return withContext(Dispatchers.IO) {
            val completeList: MutableList<CompletePost> = mutableListOf()
            val posts = someApi.getPostFromServer()
            for (post in posts ){
                val comments = someApi.getCommentsFromServer(post.postId)
               // val user = someApi.getUsersFromServer(post.userId)

                val postToDb = post.asDatabasePost()
                val commentToDb = comments.asDatabaseComment()
              //  val userToDb = user.asDatabaseUser()

                val complete = CompletePost(post.postId, postToDb, commentToDb)
                completeList.add(complete)
            }
            databasePost.insertAll(completeList)
            databasePost.getAllPosts()
        }

    }


}
