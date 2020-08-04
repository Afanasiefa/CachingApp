package com.example.testtask.ui.detailed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.dagger.App
import com.example.testtask.databinding.DetailedFragmentBinding
import com.example.testtask.ui.main.CommentsListAdapter
import com.example.testtask.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.comment_item.view.*
import javax.inject.Inject

class DetailedFragment  : Fragment() {

    private lateinit var binding: DetailedFragmentBinding
    private lateinit var viewModel: DetailedViewModel
   private lateinit var commentAdapter: CommentsListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.appComponent.inject(this)

        binding = DetailedFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailedViewModel::class.java)


        val postId = DetailedFragmentArgs.fromBundle(arguments!!).id
        viewModel.fetchPost(postId)

        viewModel.selectedPost.observe(viewLifecycleOwner, Observer {
            binding.postTitle.text = viewModel.selectedPost.value?.post?.title
            binding.postBody.text = viewModel.selectedPost.value?.post?.body
            binding.postUser.text = viewModel.selectedPost.value?.user.username
        })

        commentAdapter = CommentsListAdapter()
        binding.commentsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = commentAdapter
        }

        viewModel.commentsList.observe(viewLifecycleOwner, Observer {
            commentAdapter.submitList(it)
        })

        return binding.root
    }



}