package com.example.testtask.model.network

import com.example.testtask.model.database.DatabaseComment
import com.google.gson.annotations.SerializedName



data class CommentData(

    @SerializedName("id") val commentId: Int,
    @SerializedName("postId") val postId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("body") val body: String,
    @SerializedName("email") val email: String

){
    constructor() : this(0,0,"","","")
}


fun List<CommentData>.asDatabaseModel(): List<DatabaseComment> {
    return map {
        DatabaseComment(
            postId = it.postId,
            commentId = it.commentId,
            name = it.name,
            body = it.body,
            email = it.email
        )
    }
}
