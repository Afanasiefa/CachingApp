package com.example.testtask.ui.detailed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtask.network.post.PostData
import com.example.testtask.repository.NetworkRepository
import javax.inject.Inject

class DetailedViewModel @Inject constructor() : ViewModel() {

    private val _selectedPost = MutableLiveData<PostData>()
    val selectedPost: LiveData<PostData>
        get() = _selectedPost

}