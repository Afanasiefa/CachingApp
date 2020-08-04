package com.example.testtask.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtask.network.post.AddressData
import com.example.testtask.network.post.CompanyData


data class DatabasePost(
     val postId: Int,
     val userId: Int,
     val title: String,
     val body: String
)

data class DatabaseComment(
     val commentId: Int,
     val postId: Int,
     val name: String,
     val body: String,
     val email: String
)

data class DatabaseUser(
    val userId: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressData,
    val phone: String,
    val website: String,
    val company: CompanyData
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
    @PrimaryKey val id: Int,
    @ColumnInfo val post: DatabasePost,
    @ColumnInfo val comments: List<DatabaseComment>
   // @ColumnInfo val user: DatabaseUser
)
