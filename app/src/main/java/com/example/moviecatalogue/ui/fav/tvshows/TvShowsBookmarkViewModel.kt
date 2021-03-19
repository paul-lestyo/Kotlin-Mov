package com.example.moviecatalogue.ui.fav.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.vo.Resource

class TvShowsBookmarkViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel(){
    fun getTvShowsBookmarks(): LiveData<PagedList<TvShowsEntity>> = movieCatalogueRepository.getBookmarkedTvShows()
}