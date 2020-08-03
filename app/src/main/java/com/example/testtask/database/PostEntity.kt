package com.example.testtask.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



data class DatabasePost(
    @PrimaryKey val postId: Int,
    @ColumnInfo val userId: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val body: String
)

data class DatabaseComment(
    @PrimaryKey val commentId: Int,
    @ColumnInfo val postId: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val body: String,
    @ColumnInfo val email: String
)

data class DatabaseUser(
    val userId: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: DatabaseAdress,
    val phone: String,
    val website: String,
    val company:DatabaseCompany
)

data class DatabaseGeo(
    val lat: Double,
    val lng: Double
)

data class DatabaseCompany(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class DatabaseAdress(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: DatabaseGeo
)

////////////////////////////////////////////////////////
@Entity(tableName = "posts_table")

data class CompletePost(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val post: DatabasePost,
    @ColumnInfo val comments: List<DatabaseComment>,
    @ColumnInfo val user: DatabaseUser
)
