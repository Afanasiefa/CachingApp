package com.example.testtask.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.model.database.CompletePost
import com.example.testtask.repository.CompletePostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(private val completePostRepository: CompletePostRepository) :
    ViewModel() {

    private var _postsList = MutableLiveData<List<CompletePost>>()
    val postsList: LiveData<List<CompletePost>>
        get() = _postsList

    init {
        fetchCompletePost()
    }

    private fun fetchCompletePost() {
        viewModelScope.launch {
            Dispatchers.IO
            val post = completePostRepository.getCompletePosts()
            _postsList.postValue(post)
            Log.i("FETCHED", post.toString())
        }
    }
}