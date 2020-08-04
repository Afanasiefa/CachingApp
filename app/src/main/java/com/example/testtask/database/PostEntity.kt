package com.example.testtask.database

import androidx.room.*

@Entity(tableName = "posts_table")
data class DatabasePost(
    @PrimaryKey val postId: Int?,
    @ColumnInfo val userId: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val body: String
)


@Entity(tableName = "comments_table")
data class DatabaseComment(
    @PrimaryKey val commentId: Int,
    @ColumnInfo val postId: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val body: String,
    @ColumnInfo val email: String
)


@Entity(tableName = "users_table")
data class DatabaseUser(
    @PrimaryKey val userId: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val username: String,
    @ColumnInfo val email: String,
//    @Embedded
//    val address: DatabaseAdress,
    @ColumnInfo val phone: String,
    @ColumnInfo val website: String
//    @Embedded
//    val company: DatabaseCompany
)

//data class DatabaseGeo(
//    val lat: Double,
//    val lng: Double
//)
//
//data class DatabaseCompany(
//    val name: String,
//    val catchPhrase: String,
//    val bs: String
//)
//
//data class DatabaseAdress(
//    val street: String,
//    val suite: String,
//    val city: String,
//    val zipcode: String,
//    @Embedded
//    val geo: DatabaseGeo
//)

////////////////////////////////////////////////////////
data class CompletePost(

    @Embedded val post: DatabasePost,
    @Relation(parentColumn = "postId", entityColumn = "postId")
    var comments: List<DatabaseComment>,
    @Relation(parentColumn = "userId", entityColumn = "userId")
    var user: List<DatabaseUser>
)