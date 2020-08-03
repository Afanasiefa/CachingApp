package com.example.testtask.repository

import androidx.lifecycle.LiveData
import com.example.testtask.database.*
import com.example.testtask.modelki.Comment
import com.example.testtask.modelki.Post
import com.example.testtask.network.post.SomeApi
import com.example.testtask.network.post.asCommentDatabaseModel
import com.example.testtask.network.post.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.w3c.dom.Comment
import javax.inject.Inject

class NetworkRepository @Inject constructor(val someApi: SomeApi, val databasePost: PostDao) {

    suspend fun getPosts(): List<CompletePost> {
        return withContext(Dispatchers.IO) {
            val posts = someApi.getPostFromServer()
            for (post in posts ){
                val comments = someApi.getCommentsFromServer(post.postId)

            }
        }
    }


}
