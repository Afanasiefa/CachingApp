package com.example.testtask.model.network

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("id") val userId: Long,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("address") val address: AddressData,
    @SerializedName("phone") val phone: String,
    @SerializedName("website") val website: String,
    @SerializedName("company") val company: CompanyData
)