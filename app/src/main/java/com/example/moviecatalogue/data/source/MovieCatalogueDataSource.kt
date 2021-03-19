package com.example.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {
    fun getAllMovie(): LiveData<Resource<PagedList<MoviesEntity>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowsEntity>>>

    fun getMovie(movieId: String): LiveData<Resource<MoviesEntity>>

    fun getTvShows(tvShowsId: String): LiveData<Resource<TvShowsEntity>>

    fun getBookmarkedMovie(): LiveData<PagedList<MoviesEntity>>

    fun getBookmarkedTvShows(): LiveData<PagedList<TvShowsEntity>>

    fun setMovieBookmark(movie: MoviesEntity, state: Boolean)

    fun setTvShowsBookmark(tvShows: TvShowsEntity, state: Boolean)
}