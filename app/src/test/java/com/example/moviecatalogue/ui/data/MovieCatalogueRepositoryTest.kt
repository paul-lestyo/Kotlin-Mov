package com.example.moviecatalogue.ui.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.LiveDataTestUtil
import org.junit.Rule
import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.doAnswer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val academyRepository = FakeMovieCatalogueRepository(remote)

    private val moviesResponses = DataDummy.generateDummyMoviesResponse()
    private val movieId = moviesResponses[0].movieId

    private val tvShowsResponses = DataDummy.generateDummyTvShowsResponse()
    private val tvShowsId = tvShowsResponses[0].tvShowsId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(moviesResponses)
            null
        }.`when`(remote).getMovie(any())
        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllMovie())
        verify(remote).getMovie(any())
        assertNotNull(courseEntities)
        assertEquals(moviesResponses.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowsResponses)
            null
        }.`when`(remote).getTvShows(any())
        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllTvShows())
        verify(remote).getTvShows(any())
        assertNotNull(courseEntities)
        assertEquals(moviesResponses.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(moviesResponses)
            null
        }.`when`(remote).getMovie(any())
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(moviesResponses)
            null
        }.`when`(remote).getMovie(any())

        val courseEntitiesContent = LiveDataTestUtil.getValue(academyRepository.getMovie(movieId))

        verify(remote)
            .getMovie(any())

        verify(remote)
            .getMovie(any())

        assertNotNull(courseEntitiesContent)
        assertNotNull(courseEntitiesContent.title)
        assertNotNull(courseEntitiesContent.release_date)
        assertNotNull(courseEntitiesContent.release)
        assertNotNull(courseEntitiesContent.genres)
        assertNotNull(courseEntitiesContent.runtime)
        assertNotNull(courseEntitiesContent.score)
        assertNotNull(courseEntitiesContent.tagline)
        assertNotNull(courseEntitiesContent.description)
        assertNotNull(courseEntitiesContent.imagePath)
        assertEquals(moviesResponses[0].title, courseEntitiesContent.title)
        assertEquals(moviesResponses[0].release_date, courseEntitiesContent.release_date)
        assertEquals(moviesResponses[0].release, courseEntitiesContent.release)
        assertEquals(moviesResponses[0].genres, courseEntitiesContent.genres)
        assertEquals(moviesResponses[0].runtime, courseEntitiesContent.runtime)
        assertEquals(moviesResponses[0].score, courseEntitiesContent.score)
        assertEquals(moviesResponses[0].tagline, courseEntitiesContent.tagline)
        assertEquals(moviesResponses[0].description, courseEntitiesContent.description)
        assertEquals(moviesResponses[0].imagePath, courseEntitiesContent.imagePath)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowsResponses)
            null
        }.`when`(remote).getTvShows(any())
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowsResponses)
            null
        }.`when`(remote).getTvShows(any())

        val courseEntitiesContent = LiveDataTestUtil.getValue(academyRepository.getTvShows(tvShowsId))

        verify(remote)
            .getTvShows(any())

        verify(remote)
            .getTvShows(any())

        assertNotNull(courseEntitiesContent)
        assertNotNull(courseEntitiesContent.title)
        assertNotNull(courseEntitiesContent.genres)
        assertNotNull(courseEntitiesContent.runtime)
        assertNotNull(courseEntitiesContent.score)
        assertNotNull(courseEntitiesContent.description)
        assertNotNull(courseEntitiesContent.release)
        assertNotNull(courseEntitiesContent.imagePath)
        assertEquals(tvShowsResponses[0].title, courseEntitiesContent.title)
        assertEquals(tvShowsResponses[0].genres, courseEntitiesContent.genres)
        assertEquals(tvShowsResponses[0].runtime, courseEntitiesContent.runtime)
        assertEquals(tvShowsResponses[0].score, courseEntitiesContent.score)
        assertEquals(tvShowsResponses[0].description, courseEntitiesContent.description)
        assertEquals(tvShowsResponses[0].release, courseEntitiesContent.release)
        assertEquals(tvShowsResponses[0].imagePath, courseEntitiesContent.imagePath)
    }


}