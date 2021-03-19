package com.example.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.vo.Resource

class DetailFilmViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    val moviesId = MutableLiveData<String>()
    val tvShowsId = MutableLiveData<String>()

    fun setSelectedMovieId(moviesId: String) {
        this.moviesId.value = moviesId
    }

    fun setSelectedTvShowsId(tvShowsId: String) {
        this.tvShowsId.value = tvShowsId
    }

    var movie: LiveData<Resource<MoviesEntity>> = Transformations.switchMap(moviesId) { mMovieId ->
        movieCatalogueRepository.getMovie(mMovieId)
    }

    var tvShows: LiveData<Resource<TvShowsEntity>> = Transformations.switchMap(tvShowsId) { mTvShowsId ->
        movieCatalogueRepository.getTvShows(mTvShowsId)
    }

    fun setMovieBookmark() {
        val movieValue = movie.value
        if (movieValue != null) {
            val movie = movieValue.data
            if (movie != null) {
                val newState = !movie.bookmarked
                movieCatalogueRepository.setMovieBookmark(movie, newState)
            }
        }
    }

    fun setTvShowsBookmark() {
        val tvShowsValue = tvShows.value
        if (tvShowsValue != null) {
            val tvShows = tvShowsValue.data
            if (tvShows != null) {
                val newState = !tvShows.bookmarked
                movieCatalogueRepository.setTvShowsBookmark(tvShows, newState)
            }
        }
    }

}