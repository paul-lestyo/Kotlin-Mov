package com.example.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.di.Injection
import com.example.moviecatalogue.ui.detail.DetailFilmViewModel
import com.example.moviecatalogue.ui.fav.movies.MoviesBookmarkViewModel
import com.example.moviecatalogue.ui.fav.tvshows.TvShowsBookmarkViewModel
import com.example.moviecatalogue.ui.movies.MoviesViewModel
import com.example.moviecatalogue.ui.tvshows.TvShowsViewModel

class ViewModelFactory private constructor(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                return TvShowsViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailFilmViewModel::class.java) -> {
                return DetailFilmViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(MoviesBookmarkViewModel::class.java) -> {
                return MoviesBookmarkViewModel(movieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowsBookmarkViewModel::class.java) -> {
                return TvShowsBookmarkViewModel(movieCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}