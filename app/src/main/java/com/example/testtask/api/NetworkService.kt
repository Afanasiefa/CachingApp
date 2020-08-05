package com.example.testtask.api

import com.example.testtask.model.network.CommentData
import com.example.testtask.model.network.PostData
import com.example.testtask.model.network.UserData
import retrofit2.http.GET

interface  NetworkService{
    @GET("posts")
    suspend fun getPostFromServer(): List<PostData>

    @GET("comments")
    suspend fun getCommentsFromServer(): List<CommentData>

    @GET("users")
    suspend fun getUsersFromServer(): List<UserData>
}