package com.example.moviecatalogue.ui.fav.tvshows

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.databinding.FragmentTvShowsFavBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class TvShowsFavFragment : Fragment() {
    private var fragmentTvShowsFavBinding: FragmentTvShowsFavBinding? = null
    private val binding get() = fragmentTvShowsFavBinding

    private lateinit var viewModel: TvShowsBookmarkViewModel
    private lateinit var adapter: TvShowsBookmarkAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentTvShowsFavBinding = FragmentTvShowsFavBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowsBookmarkViewModel::class.java]

            adapter = TvShowsBookmarkAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getTvShowsBookmarks().observe(viewLifecycleOwner, { courses ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(courses)
            })

            binding?.rvTvShowsFav?.layoutManager = LinearLayoutManager(context)
            binding?.rvTvShowsFav?.setHasFixedSize(true)
            binding?.rvTvShowsFav?.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("akowakwo","hadeh")
        adapter.notifyDataSetChanged()
    }
}