package com.example.testtask.network.post


import retrofit2.http.GET

interface SomeApi {
    @GET("posts")
    suspend fun getPostFromServer(): List<PostData>

    @GET("comments")
    suspend fun getCommentsFromServer(): List<CommentData>

    @GET("users")
    suspend fun getUsersFromServer(): List<UserData>
}