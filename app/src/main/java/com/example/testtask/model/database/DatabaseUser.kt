package com.example.testtask.model.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class DatabaseUser(
    @PrimaryKey val userId: Long,
    @ColumnInfo val name: String,
    @ColumnInfo val username: String,
    @ColumnInfo val email: String,
    @Embedded
    val address: DatabaseAddress,
    @ColumnInfo val phone: String,
    @ColumnInfo val website: String,
    @Embedded
    val company: DatabaseCompany
)