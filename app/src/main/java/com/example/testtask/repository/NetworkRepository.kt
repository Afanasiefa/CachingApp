package com.example.testtask.repository

import com.example.testtask.api.NetworkService
import com.example.testtask.database.CompletePostDao
import com.example.testtask.model.database.CompletePost
import com.example.testtask.utils.commentAsDatabaseModel
import com.example.testtask.utils.postAsDatabaseModel
import com.example.testtask.utils.userAsDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CompletePostRepository @Inject constructor(
    private val networkService: NetworkService, private val completePostDao: CompletePostDao
) {

    suspend fun getCompletePosts(): List<CompletePost> {
        return withContext(Dispatchers.IO) {
            val posts = networkService.getPostFromServer()
            val comments = networkService.getCommentsFromServer()
            val user = networkService.getUsersFromServer()

            val postToDb = posts.postAsDatabaseModel()
            val commentToDb = comments.commentAsDatabaseModel()
            val userToDb = user.userAsDatabaseModel()

            completePostDao.apply {
                insertAllPosts(postToDb)
                insertAllComments(commentToDb)
                insertAllUsers(userToDb)
            }
            completePostDao.getAllPosts()
        }
    }
}