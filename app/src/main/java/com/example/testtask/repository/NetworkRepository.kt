package com.example.testtask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.testtask.database.PostDao
import com.example.testtask.database.asDomainModel
import com.example.testtask.modelki.Post
import com.example.testtask.network.post.SomeApi
import com.example.testtask.network.post.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkRepository @Inject constructor(val someApi: SomeApi, val databasePost: PostDao) {

    suspend fun getPosts(): LiveData<List<Post>> {
        return withContext(Dispatchers.IO) {
            val postFromServer = someApi.getPostFromServer()
            Log.i("one", postFromServer.toString())
            databasePost.insertAll(postFromServer.asDatabaseModel())
            val post: LiveData<List<Post>> = Transformations.map(databasePost.getAllPosts()) {
                it.asDomainModel()
            }
            post
        }
    }

}
