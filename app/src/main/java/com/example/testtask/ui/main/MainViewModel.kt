package com.example.testtask.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.modelki.Post
import com.example.testtask.network.post.PostData
import com.example.testtask.repository.NetworkRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(val networkRepository: NetworkRepository)  : ViewModel() {

    private var _postsList = MutableLiveData<List<Post>>()
    val postsList: LiveData<List<Post>>
    get() = _postsList

    init {
        fetchPost()
    }

     fun fetchPost(){
        viewModelScope.launch {
            val post = networkRepository.getPosts()
            _postsList.value = post.value
            Log.i("TAG", post.value.toString())
        }
    }
}