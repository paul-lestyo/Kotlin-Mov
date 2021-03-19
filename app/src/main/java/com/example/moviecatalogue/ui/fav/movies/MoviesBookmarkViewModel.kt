package com.example.moviecatalogue.ui.fav.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.vo.Resource

class MoviesBookmarkViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel(){
    fun getMovieBookmarks(): LiveData<PagedList<MoviesEntity>> = movieCatalogueRepository.getBookmarkedMovie()

}