package com.example.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM MoviesEntity")
    fun getMovie(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM MoviesEntity where bookmarked = 1")
    fun getBookmarkedMovie(): DataSource.Factory<Int, MoviesEntity>

    @Transaction
    @Query("SELECT * FROM MoviesEntity WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MoviesEntity>)

    @Update
    fun updateMovie(course: MoviesEntity)

    @Query("SELECT * FROM TvShowsEntity")
    fun getTvShows(): DataSource.Factory<Int,TvShowsEntity>

    @Query("SELECT * FROM TvShowsEntity where bookmarked = 1")
    fun getBookmarkedTvShows(): DataSource.Factory<Int,TvShowsEntity>

    @Transaction
    @Query("SELECT * FROM TvShowsEntity WHERE tvShowsId = :tvShowsId")
    fun getTvShowsById(tvShowsId: String): LiveData<TvShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowsEntity>)

    @Update
    fun updateTvShows(course: TvShowsEntity)


}
