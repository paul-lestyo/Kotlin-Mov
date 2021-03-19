package com.example.moviecatalogue.data.source.remote

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowsResponse
import com.example.moviecatalogue.utils.EspressoIdlingResource
import com.example.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getMovie(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovie())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShowsResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowsResponse>>>()
        handler.postDelayed({
            resultTvShows.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShows
    }

    fun getMovieById(movieId: String): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({
            val movies = jsonHelper.loadMovie()

            for (movie in movies) {
                if (movie.movieId == movieId) {
                    val movieResult = MovieResponse(movie.movieId,
                        movie.title,
                        movie.release_date,
                        movie.release,
                        movie.genres,
                        movie.runtime,
                        movie.score,
                        movie.tagline,
                        movie.description,
                        movie.imagePath)
                    resultMovie.value = ApiResponse.success( movieResult )
                }
            }
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getTvShowsById(tvShowsId: String): LiveData<ApiResponse<TvShowsResponse>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<TvShowsResponse>>()
        handler.postDelayed({
            val tvShows = jsonHelper.loadTvShows()

            for (tvShow in tvShows) {
                if (tvShow.tvShowsId == tvShowsId) {
                    val tvShowsResult = TvShowsResponse(tvShow.tvShowsId,
                        tvShow.title,
                        tvShow.genres,
                        tvShow.runtime,
                        tvShow.score,
                        tvShow.description,
                        tvShow.release,
                        tvShow.imagePath)
                    resultTvShows.value = ApiResponse.success( tvShowsResult )
                }
            }
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShows
    }


}