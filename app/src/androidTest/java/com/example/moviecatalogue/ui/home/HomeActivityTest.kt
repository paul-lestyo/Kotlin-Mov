package com.example.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviecatalogue.R
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText("${dummyMovies[0].title} - ${dummyMovies[0].release_date}")))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyMovies[0].genres)))
        onView(withId(R.id.tv_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_score)).check(matches(withText(dummyMovies[0].score)))
        onView(withId(R.id.tv_detail_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_runtime)).check(matches(withText(dummyMovies[0].runtime)))
        onView(withId(R.id.tv_detail_datetime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_datetime)).check(matches(withText(dummyMovies[0].release)))
        onView(withId(R.id.tv_detail_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_description)).check(matches(withText(dummyMovies[0].description)))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText("${dummyTvShows[0].title} - ${dummyTvShows[0].release}")))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyTvShows[0].genres)))
        onView(withId(R.id.tv_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_score)).check(matches(withText(dummyTvShows[0].score)))
        onView(withId(R.id.tv_detail_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_runtime)).check(matches(withText(dummyTvShows[0].runtime)))
        onView(withId(R.id.tv_detail_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_description)).check(matches(withText(dummyTvShows[0].description)))

    }
}