package com.example.testtask.ui.detailed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtask.database.CompletePost
import javax.inject.Inject

class DetailedViewModel @Inject constructor() : ViewModel() {

    private val _selectedPost = MutableLiveData<CompletePost>()
    val selectedPost: LiveData<CompletePost>
        get() = _selectedPost



}