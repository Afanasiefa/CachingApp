package com.example.testtask.network.post

import android.os.Parcelable
import com.example.testtask.database.DatabasePost
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostData(
    @SerializedName("id") val postId: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
) : Parcelable

fun PostData.asDatabasePost(): DatabasePost {
    return DatabasePost(
        postId = postId,
        userId = userId,
        title = title,
        body = body
    )

}


