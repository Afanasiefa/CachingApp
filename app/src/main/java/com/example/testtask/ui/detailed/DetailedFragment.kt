package com.example.testtask.ui.detailed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.testtask.dagger.App
import com.example.testtask.viewmodel.ViewModelFactory
import com.example.testtask.databinding.DetailedFragmentBinding
import javax.inject.Inject

class DetailedFragment : Fragment() {

    private lateinit var binding: DetailedFragmentBinding
    private lateinit var viewModel: DetailedViewModel
    private lateinit var commentAdapter: CommentsListAdapter
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.appComponent.inject(this)

        binding = DetailedFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailedViewModel::class.java)


        val post = DetailedFragmentArgs.fromBundle(arguments!!).post
        binding.postTitle.text = post.title
        binding.postBody.text = post.body

        return binding.root
    }


}