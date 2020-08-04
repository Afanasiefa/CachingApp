package com.example.testtask.network.post

import android.os.Parcelable
import com.example.testtask.database.DatabaseComment
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CommentData(

    @SerializedName("id") val commentId: Int,
    @SerializedName("postId") val postId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("body") val body: String,
    @SerializedName("email") val email: String

) : Parcelable


fun List<CommentData>.asDatabaseComment(): List<DatabaseComment> {
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
