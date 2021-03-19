package com.example.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.remote.ApiResponse
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowsResponse
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.vo.Resource

class MovieCatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovie(): LiveData<Resource<PagedList<MoviesEntity>>> {
        return object : NetworkBoundResource<PagedList<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MoviesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()
            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovie()
            public override fun saveCallResult(movieResponses: List<MovieResponse>) {
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
                        false,
                        response.imagePath)
                    movieList.add(movie)
                }

                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }


    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowsEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowsEntity>, List<TvShowsResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowsEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }
            override fun shouldFetch(data: PagedList<TvShowsEntity>?): Boolean =
                data == null || data.isEmpty()
            public override fun createCall(): LiveData<ApiResponse<List<TvShowsResponse>>> =
                remoteDataSource.getTvShows()
            public override fun saveCallResult(tvShowsResponses: List<TvShowsResponse>) {
                val tvShowsList = ArrayList<TvShowsEntity>()
                for (response in tvShowsResponses) {
                    val tvShows = TvShowsEntity(response.tvShowsId,
                        response.title,
                        response.genres,
                        response.runtime,
                        response.score,
                        response.description,
                        response.release,
                        false,
                        response.imagePath)
                    tvShowsList.add(tvShows)
                }

                localDataSource.insertTvShows(tvShowsList)
            }
        }.asLiveData()
    }

    override fun getMovie(movieId: String): LiveData<Resource<MoviesEntity>> {
        return object : NetworkBoundResource<MoviesEntity, MovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MoviesEntity> =
                localDataSource.getMovieById(movieId)
            override fun shouldFetch(movie: MoviesEntity?): Boolean =
                movie?.movieId == null
            override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getMovieById(movieId)
            override fun saveCallResult(response: MovieResponse) {
                val movie = MoviesEntity(response.movieId,
                    response.title,
                    response.release_date,
                    response.release,
                    response.genres,
                    response.runtime,
                    response.score,
                    response.tagline,
                    response.description,
                    false,
                    response.imagePath)


                localDataSource.updateMovie(movie)
            }
        }.asLiveData()
    }


    override fun getTvShows(tvShowsId: String): LiveData<Resource<TvShowsEntity>> {
        return object : NetworkBoundResource<TvShowsEntity, TvShowsResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowsEntity> =
                localDataSource.getTvShowsById(tvShowsId)
            override fun shouldFetch(movie: TvShowsEntity?): Boolean =
                movie?.tvShowsId == null
            override fun createCall(): LiveData<ApiResponse<TvShowsResponse>> =
                remoteDataSource.getTvShowsById(tvShowsId)
            override fun saveCallResult(response: TvShowsResponse) {
                val tvShows = TvShowsEntity(response.tvShowsId,
                    response.title,
                    response.genres,
                    response.runtime,
                    response.score,
                    response.description,
                    response.release,
                    false,
                    response.imagePath)


                localDataSource.updateTvShows(tvShows)
            }
        }.asLiveData()
    }


    override fun getBookmarkedMovie(): LiveData<PagedList<MoviesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovie(), config).build()
    }

    override fun getBookmarkedTvShows(): LiveData<PagedList<TvShowsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedTvShows(), config).build()
    }

    override fun setMovieBookmark(movie: MoviesEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setMovieBookmark(movie, state) }
    }

    override fun setTvShowsBookmark(tvShows: TvShowsEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvShowsBookmark(tvShows, state) }
    }
}