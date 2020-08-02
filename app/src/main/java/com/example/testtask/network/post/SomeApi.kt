package com.example.testtask.network.post

import com.example.testtask.network.post.PostData
import retrofit2.http.GET

interface SomeApi{
    @GET("posts")
    suspend fun getPostFromServer() : List<PostData>
}