package com.example.testtask.model.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class DatabaseUser(
    @PrimaryKey val userId: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val username: String,
    @ColumnInfo val email: String,
    @Embedded
    val address: DatabaseAdress,
    @ColumnInfo val phone: String,
    @ColumnInfo val website: String,
    @Embedded
    val company: DatabaseCompany
)

data class DatabaseGeo(
    val lat: Double,
    val lng: Double
)

data class DatabaseCompany(
    val companyName: String,
    val catchPhrase: String,
    val bs: String
)

data class DatabaseAdress(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    @Embedded
    val geo: DatabaseGeo
)
