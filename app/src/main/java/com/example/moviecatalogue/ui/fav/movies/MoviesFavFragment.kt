package com.example.moviecatalogue.ui.fav.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.FragmentMoviesFavBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class MoviesFavFragment : Fragment() {
    private var fragmentMoviesFavBinding: FragmentMoviesFavBinding? = null
    private val binding get() = fragmentMoviesFavBinding

    private lateinit var viewModel: MoviesBookmarkViewModel
    private lateinit var adapter: MoviesBookmarkAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentMoviesFavBinding = FragmentMoviesFavBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MoviesBookmarkViewModel::class.java]

            adapter = MoviesBookmarkAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getMovieBookmarks().observe(requireActivity(), { courses ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(courses)
            })

            binding?.rvMoviesFav?.layoutManager = LinearLayoutManager(context)
            binding?.rvMoviesFav?.setHasFixedSize(true)
            binding?.rvMoviesFav?.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

}