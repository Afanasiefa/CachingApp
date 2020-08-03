package com.example.testtask.network.post


import android.service.autofill.UserData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SomeApi{
    @GET("posts")
    suspend fun getPostFromServer() : List<PostData>

    @GET("comments")
    suspend fun getCommentsFromServer(
        @Query("postId") postId: Int
    ) : List<CommentData>

    @GET("users/{userId}")
    suspend fun getUsersFromServer(
        @Path("id") userId: Int
    ) : List<UserData>
}