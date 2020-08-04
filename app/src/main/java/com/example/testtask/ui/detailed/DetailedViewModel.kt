package com.example.testtask.ui.detailed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.database.CompletePost
import com.example.testtask.database.DatabaseComment
import com.example.testtask.database.PostDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailedViewModel @Inject constructor(val postDao: PostDao) :
    ViewModel() {

    private val _selectedPost = MutableLiveData<CompletePost>()
    val selectedPost: LiveData<CompletePost>
        get() = _selectedPost

    private val _commentsList = MutableLiveData<List<DatabaseComment>>()
    val commentsList: LiveData<List<DatabaseComment>>
        get() = _commentsList


    fun fetchPost(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val post = postDao.getPostById(id)
            _selectedPost.postValue(post)
            Log.i("TAG2", id.toInt().toString())
            Log.i("TAG21", post.toString())
            _commentsList.postValue(post.comments)
        }
    }

}