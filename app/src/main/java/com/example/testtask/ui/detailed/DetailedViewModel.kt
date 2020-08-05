package com.example.testtask.ui.detailed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.model.database.CompletePost
import com.example.testtask.model.database.DatabaseComment
import com.example.testtask.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailedViewModel @Inject constructor(private val databaseRepository: DatabaseRepository) :
    ViewModel() {

    private val _selectedPost = MutableLiveData<CompletePost>()
    val selectedPost: LiveData<CompletePost>
        get() = _selectedPost

    private val _commentsList = MutableLiveData<List<DatabaseComment>>()
    val commentsList: LiveData<List<DatabaseComment>>
        get() = _commentsList

    fun fetchPost(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val post = databaseRepository.getCompletePostWithId(id)
            _selectedPost.postValue(post)
            _commentsList.postValue(post.comments)
        }
    }
}