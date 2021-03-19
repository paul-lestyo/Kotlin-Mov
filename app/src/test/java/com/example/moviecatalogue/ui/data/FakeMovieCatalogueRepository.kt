package com.example.moviecatalogue.ui.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.MovieCatalogueDataSource
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowsResponse

class FakeMovieCatalogueRepository(private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource {

    override fun getAllMovie(): LiveData<List<MoviesEntity>> {
        val movieResult = MutableLiveData <List<MoviesEntity>>()
        remoteDataSource.getMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in movieResponses) {
                    val movie = MoviesEntity(response.movieId,
                        response.title,
                        response.release_date,
                        response.release,
                        response.genres,
                        response.runtime,
                        response.score,
                        response.tagline,
                        response.description,
                        response.imagePath)
                    movieList.add(movie)
                }
                movieResult.postValue(movieList)
            }
        })

        return movieResult
    }

    override fun getAllTvShows(): LiveData<List<TvShowsEntity>> {
        val tvShowsResult = MutableLiveData <List<TvShowsEntity>>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowsResponses: List<TvShowsResponse>) {
                val tvShowsList = ArrayList<TvShowsEntity>()
                for (response in tvShowsResponses) {
                    val tvShows = TvShowsEntity(response.tvShowsId,
                        response.title,
                        response.genres,
                        response.runtime,
                        response.score,
                        response.description,
                        response.release,
                        response.imagePath)
                    tvShowsList.add(tvShows)
                }
                tvShowsResult.postValue(tvShowsList)
            }
        })

        return tvShowsResult
    }

    override fun getMovie(movieId: String): LiveData<MoviesEntity> {
        val movieResult = MutableLiveData<MoviesEntity>()
        remoteDataSource.getMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponses: List<MovieResponse>) {
                lateinit var movie: MoviesEntity
                for (response in movieResponses) {
                    if (response.movieId == movieId) {
                        movie = MoviesEntity(response.movieId,
                            response.title,
                            response.release_date,
                            response.release,
                            response.genres,
                            response.runtime,
                            response.score,
                            response.tagline,
                            response.description,
                            response.imagePath)
                    }
                }
                movieResult.postValue(movie)
            }
        })

        return movieResult
    }

    override fun getTvShows(tvShowsId: String): LiveData<TvShowsEntity> {
        val tvShowsResult = MutableLiveData<TvShowsEntity>()
        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowsResponses: List<TvShowsResponse>) {
                lateinit var tvShows: TvShowsEntity
                for (response in tvShowsResponses) {
                    if (response.tvShowsId == tvShowsId) {
                        tvShows = TvShowsEntity(response.tvShowsId,
                            response.title,
                            response.genres,
                            response.runtime,
                            response.score,
                            response.description,
                            response.release,
                            response.imagePath)
                    }
                }
                tvShowsResult.postValue(tvShows)
            }
        })

        return tvShowsResult
    }
}