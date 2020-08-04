package com.example.testtask.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.dagger.App
import com.example.testtask.databinding.MainFragmentBinding
import com.example.testtask.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var postsAdapter: PostsListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        App.appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        binding = MainFragmentBinding.inflate(inflater)



        postsAdapter = PostsListAdapter(PostsListAdapter.PostClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToDetailedFragment(
                    it.post.postId.toLong()
                )
            )
        })

        binding.postsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postsAdapter
        }

        viewModel.postsList.observe(viewLifecycleOwner, Observer {
            postsAdapter.submitList(it)
        })
        return binding.root
    }

}