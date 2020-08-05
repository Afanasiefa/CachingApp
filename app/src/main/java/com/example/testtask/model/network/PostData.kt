package com.example.testtask.model.network

import com.google.gson.annotations.SerializedName

data class PostData(
    @SerializedName("id") val postId: Long,
    @SerializedName("userId") val userId: Long,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)