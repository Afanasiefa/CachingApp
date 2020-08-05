package com.example.testtask.model.network

import android.os.Parcelable
import com.example.testtask.model.database.DatabaseAdress
import com.example.testtask.model.database.DatabaseCompany
import com.example.testtask.model.database.DatabaseGeo
import com.example.testtask.model.database.DatabaseUser
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(
    @SerializedName("id") val userId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("address") val address: AddressData,
    @SerializedName("phone") val phone: String,
    @SerializedName("website") val website: String,
    @SerializedName("company") val company: CompanyData
) : Parcelable

@Parcelize
data class GeoData(

    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
) : Parcelable

@Parcelize
data class CompanyData(

    @SerializedName("name") val name: String,
    @SerializedName("catchPhrase") val catchPhrase: String,
    @SerializedName("bs") val bs: String
) : Parcelable

@Parcelize
data class AddressData(

    @SerializedName("street") val street: String,
    @SerializedName("suite") val suite: String,
    @SerializedName("city") val city: String,
    @SerializedName("zipcode") val zipcode: String,
    @SerializedName("geo") val geo: GeoData
) : Parcelable

fun List<UserData>.asDatabaseModel(): List<DatabaseUser> {
    return map {
        DatabaseUser(
            userId = it.userId,
            name = it.name,
            username = it.username,
            email = it.email,
            phone = it.phone,
            website = it.website,
            address = DatabaseAdress(
                street = it.address.street,
                suite = it.address.suite,
                city = it.address.city,
                zipcode = it.address.zipcode,
                geo = DatabaseGeo(
                    lat = it.address.geo.lat,
                    lng = it.address.geo.lng
                )
            ),
            company = DatabaseCompany(
                companyName = it.company.name,
                catchPhrase = it.company.catchPhrase,
                bs = it.company.bs
            )
        )
    }

}

