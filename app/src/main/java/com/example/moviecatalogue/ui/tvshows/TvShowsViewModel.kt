package com.example.moviecatalogue.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.vo.Resource

class TvShowsViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel(){
    fun getTvShows(): LiveData<Resource<PagedList<TvShowsEntity>>> = movieCatalogueRepository.getAllTvShows()
}