package com.example.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.example.moviecatalogue.databinding.ContentDetailFilmBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.vo.Status

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_TV_SHOWS = "extra_tv_shows"
    }

    private lateinit var detailContentBinding: ContentDetailFilmBinding
    private lateinit var activityDetailCourseBinding : ActivityDetailFilmBinding
    private lateinit var viewModel:DetailFilmViewModel
    private lateinit var movieId: String
    private lateinit var tvShowsId: String
    private var menu: Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailCourseBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        setContentView(activityDetailCourseBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIES)
            val tvShowsId = extras.getString(EXTRA_TV_SHOWS)
            if (movieId != null) {
                activityDetailCourseBinding.content.visibility = View.GONE
                activityDetailCourseBinding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedMovieId(movieId)
                viewModel.movie.observe(this, { courseWithModuleResource ->
                    if (courseWithModuleResource != null) {
                        when (courseWithModuleResource.status) {
                            Status.LOADING -> activityDetailCourseBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> if (courseWithModuleResource.data != null) {
                                activityDetailCourseBinding?.progressBar?.visibility = View.GONE
                                activityDetailCourseBinding?.content?.visibility = View.VISIBLE
                                populateMovies(courseWithModuleResource.data)
                            }
                            Status.ERROR -> {
                                activityDetailCourseBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            } else if(tvShowsId != null) {
                activityDetailCourseBinding.content.visibility = View.GONE
                activityDetailCourseBinding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedTvShowsId(tvShowsId)
                viewModel.tvShows.observe(this, { courseWithModuleResource ->
                    if (courseWithModuleResource != null) {
                        when (courseWithModuleResource.status) {
                            Status.LOADING -> activityDetailCourseBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> if (courseWithModuleResource.data != null) {
                                activityDetailCourseBinding?.progressBar?.visibility = View.GONE
                                activityDetailCourseBinding?.content?.visibility = View.VISIBLE
                                populateTvShows(courseWithModuleResource.data)
                            }
                            Status.ERROR -> {
                                activityDetailCourseBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

    }

    private fun populateMovies(moviesEntity: MoviesEntity) {
        detailContentBinding.tvDetailTitle.text = "${moviesEntity.title} - ${moviesEntity.release_date}"
        detailContentBinding.tvDetailDescription.text = moviesEntity.description
        detailContentBinding.tvDetailDatetime.text = moviesEntity.release
        detailContentBinding.tvDetailGenre.text = moviesEntity.genres
        detailContentBinding.tvDetailRuntime.text = moviesEntity.runtime
        detailContentBinding.tvDetailScore.text = moviesEntity.score
        detailContentBinding.tvDetailTagline.text = moviesEntity.tagline

        Glide.with(this)
                .load(moviesEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imgPoster)
    }

    private fun populateTvShows(tvShowsEntity: TvShowsEntity) {
        detailContentBinding.tvDetailTitle.text = "${tvShowsEntity.title} - ${tvShowsEntity.release}"
        detailContentBinding.tvDetailDescription.text = tvShowsEntity.description
        detailContentBinding.tvDetailGenre.text = tvShowsEntity.genres
        detailContentBinding.tvDetailRuntime.text = tvShowsEntity.runtime
        detailContentBinding.tvDetailScore.text = tvShowsEntity.score

        Glide.with(this)
                .load(tvShowsEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imgPoster)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIES)
            val tvShowsId = extras.getString(EXTRA_TV_SHOWS)
            if (movieId != null) {
                viewModel.movie.observe(this, { courseWithModule ->
                    if (courseWithModule != null) {
                        when (courseWithModule.status) {
                            Status.LOADING -> activityDetailCourseBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> if (courseWithModule.data != null) {
                                activityDetailCourseBinding?.progressBar?.visibility = View.GONE
                                val state = courseWithModule.data.bookmarked
                                setBookmarkState(state)
                            }
                            Status.ERROR -> {
                                activityDetailCourseBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            } else if(tvShowsId != null) {
                viewModel.tvShows.observe(this, { courseWithModule ->
                    if (courseWithModule != null) {
                        when (courseWithModule.status) {
                            Status.LOADING -> activityDetailCourseBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> if (courseWithModule.data != null) {
                                activityDetailCourseBinding?.progressBar?.visibility = View.GONE
                                val state = courseWithModule.data.bookmarked
                                setBookmarkState(state)
                            }
                            Status.ERROR -> {
                                activityDetailCourseBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark) {
            val extras = intent.extras
            if (extras != null) {
                val movieId = extras.getString(EXTRA_MOVIES)
                val tvShowsId = extras.getString(EXTRA_TV_SHOWS)
                if (movieId != null) {
                    viewModel.setMovieBookmark()
                    return true
                } else if(tvShowsId != null) {
                    viewModel.setTvShowsBookmark()
                    return true
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }
    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }
}