package com.example.testtask.utils

import com.example.testtask.model.database.*
import com.example.testtask.model.network.CommentData
import com.example.testtask.model.network.PostData
import com.example.testtask.model.network.UserData

fun List<PostData>.postAsDatabaseModel(): List<DatabasePost> {
    return map {
        DatabasePost(
            postId = it.postId,
            userId = it.userId,
            title = it.title,
            body = it.body
        )
    }
}

fun List<UserData>.userAsDatabaseModel(): List<DatabaseUser> {
    return map {
        DatabaseUser(
            userId = it.userId,
            name = it.name,
            username = it.username,
            email = it.email,
            phone = it.phone,
            website = it.website,
            address = DatabaseAddress(
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

fun List<CommentData>.commentAsDatabaseModel(): List<DatabaseComment> {
    return map {
        DatabaseComment(
            postId = it.postId,
            commentId = it.commentId,
            name = it.name,
            body = it.body,
            email = it.email
        )
    }
}
