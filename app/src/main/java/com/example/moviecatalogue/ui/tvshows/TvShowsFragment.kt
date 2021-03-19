package com.example.moviecatalogue.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.databinding.FragmentTvShowsBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.vo.Status

class TvShowsFragment : Fragment() {
    private lateinit var fragmentTvShowsBinding: FragmentTvShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowsViewModel::class.java]
            val courses = viewModel.getTvShows()

            val tvShowsAdapter = TvShowsAdapter()
            fragmentTvShowsBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShows().observe(viewLifecycleOwner, { courses ->
                if (courses != null) {
                    when (courses.status) {
                        Status.LOADING -> fragmentTvShowsBinding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvShowsBinding?.progressBar?.visibility = View.GONE
                            tvShowsAdapter.submitList(courses.data)
                            tvShowsAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentTvShowsBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvShowsBinding.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }
}