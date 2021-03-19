package com.example.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val movieCatalogueDao: MovieCatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, MoviesEntity> = movieCatalogueDao.getMovie()

    fun getBookmarkedMovie(): DataSource.Factory<Int, MoviesEntity> = movieCatalogueDao.getBookmarkedMovie()

    fun getMovieById(movieId: String): LiveData<MoviesEntity> =
        movieCatalogueDao.getMovieById(movieId)


    fun insertMovie(movie: List<MoviesEntity>) = movieCatalogueDao.insertMovie(movie)

    fun updateMovie(movie: MoviesEntity) {
        movieCatalogueDao.updateMovie(movie)
    }

    fun setMovieBookmark(movie: MoviesEntity, newState: Boolean) {
        movie.bookmarked = newState
        movieCatalogueDao.updateMovie(movie)
    }

    fun getAllTvShows(): DataSource.Factory<Int, TvShowsEntity> = movieCatalogueDao.getTvShows()

    fun getBookmarkedTvShows(): DataSource.Factory<Int, TvShowsEntity> = movieCatalogueDao.getBookmarkedTvShows()

    fun getTvShowsById(tvShowsId: String): LiveData<TvShowsEntity> =
        movieCatalogueDao.getTvShowsById(tvShowsId)


    fun insertTvShows(tvShows: List<TvShowsEntity>) = movieCatalogueDao.insertTvShows(tvShows)

    fun updateTvShows(tvShows: TvShowsEntity) {
        movieCatalogueDao.updateTvShows(tvShows)
    }

    fun setTvShowsBookmark(tvShows: TvShowsEntity, newState: Boolean) {
        tvShows.bookmarked = newState
        movieCatalogueDao.updateTvShows(tvShows)
    }

}