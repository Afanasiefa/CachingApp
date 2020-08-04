package com.example.testtask.network.post

import com.example.testtask.database.DatabasePost
import com.google.gson.annotations.SerializedName


data class PostData(
    @SerializedName("id") val postId: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)


fun List<PostData>.asDatabaseModel(): List<DatabasePost> {
    return map {
        DatabasePost(
            postId = it.postId,
            userId = it.userId,
            title = it.title,
            body = it.body
        )
    }

}

