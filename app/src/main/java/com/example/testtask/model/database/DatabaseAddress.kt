package com.example.testtask.model.database

import androidx.room.Embedded

data class DatabaseAddress(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    @Embedded
    val geo: DatabaseGeo
)