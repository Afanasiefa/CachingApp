package com.example.testtask.model.network

import com.google.gson.annotations.SerializedName

data class AddressData(
    @SerializedName("street") val street: String,
    @SerializedName("suite") val suite: String,
    @SerializedName("city") val city: String,
    @SerializedName("zipcode") val zipcode: String,
    @SerializedName("geo") val geo: GeoData
)
