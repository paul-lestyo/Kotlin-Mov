package com.example.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailFilmViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val moviesId = dummyMovies.movieId
    private val dummyTvShows = DataDummy.generateDummyTvShows()[0]
    private val tvShowsId = dummyTvShows.tvShowsId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<MoviesEntity>

    @Mock
    private lateinit var tvShowsObserver: Observer<TvShowsEntity>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(movieCatalogueRepository)
        viewModel.setSelectedMovies(moviesId)
        viewModel.setSelectedTvShowsId(tvShowsId)
    }

    @Test
    fun getMovies() {
        val movie = MutableLiveData<MoviesEntity>()
        movie.value = dummyMovies

        `when`(movieCatalogueRepository.getMovie(moviesId)).thenReturn(movie)
        val moviesEntity = viewModel.getMovies().value as MoviesEntity
        verify(movieCatalogueRepository).getMovie(moviesId)
        assertNotNull(moviesEntity)
        assertEquals(dummyMovies.movieId, moviesEntity.movieId)
        assertEquals(dummyMovies.title, moviesEntity.title)
        assertEquals(dummyMovies.description, moviesEntity.description)
        assertEquals(dummyMovies.imagePath, moviesEntity.imagePath)
        assertEquals(dummyMovies.genres, moviesEntity.genres)

        viewModel.getMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getTvShows() {
        val tvShows = MutableLiveData<TvShowsEntity>()
        tvShows.value = dummyTvShows

        `when`(movieCatalogueRepository.getTvShows(tvShowsId)).thenReturn(tvShows)
        val tvShowsEntity = viewModel.getTvShows().value as TvShowsEntity
        verify(movieCatalogueRepository).getTvShows(tvShowsId)
        assertNotNull(tvShowsEntity)
        assertEquals(dummyTvShows.tvShowsId, tvShowsEntity.tvShowsId)
        assertEquals(dummyTvShows.title, tvShowsEntity.title)
        assertEquals(dummyTvShows.description, tvShowsEntity.description)
        assertEquals(dummyTvShows.imagePath, tvShowsEntity.imagePath)
        assertEquals(dummyTvShows.genres, tvShowsEntity.genres)

        viewModel.getTvShows().observeForever(tvShowsObserver)
        verify(tvShowsObserver).onChanged(dummyTvShows)
    }
}