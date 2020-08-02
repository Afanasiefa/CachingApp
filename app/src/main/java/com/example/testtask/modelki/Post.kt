package com.example.testtask.modelki

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
     val id: Int,
     val userId: Int,
     val title: String,
     val body: String
) : Parcelable