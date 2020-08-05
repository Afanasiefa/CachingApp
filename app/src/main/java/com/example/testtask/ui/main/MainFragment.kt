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
import com.example.testtask.dagger.modules.viewmodel.ViewModelFactory
import com.example.testtask.databinding.MainFragmentBinding
import javax.inject.Inject

class MainFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var fragmentViewModel: MainFragmentViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var postsAdapter: PostsListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        App.appComponent.inject(this)
        fragmentViewModel = ViewModelProvider(this, viewModelFactory).get(MainFragmentViewModel::class.java)
        binding = MainFragmentBinding.inflate(inflater)

        postsAdapter = PostsListAdapter(PostsListAdapter.PostClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToDetailedFragment(
                    it.post.postId
                )
            )
        })

        binding.postsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postsAdapter
        }

        fragmentViewModel.postsList.observe(viewLifecycleOwner, Observer {
            postsAdapter.submitList(it)
        })
        return binding.root
    }

}