package com.example.testtask.model.network

import com.google.gson.annotations.SerializedName

data class CommentData(
    @SerializedName("id") val commentId: Long,
    @SerializedName("postId") val postId: Long,
    @SerializedName("name") val name: String,
    @SerializedName("body") val body: String,
    @SerializedName("email") val email: String
)
