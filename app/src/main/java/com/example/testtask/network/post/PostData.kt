package com.example.testtask.network.post

import android.net.Network
import android.os.Parcelable
import androidx.lifecycle.Transformations.map
import com.example.testtask.database.DatabasePost
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostData(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
    ) : Parcelable

fun List<PostData>.asDatabaseModel(): List<DatabasePost> {
    return map {
        DatabasePost(
            id = it.id,
            userId = it.userId,
            title = it.title,
            body = it.body
        )
    }
}
