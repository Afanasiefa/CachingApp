package com.example.testtask.model.network

import com.google.gson.annotations.SerializedName

data class GeoData(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
)