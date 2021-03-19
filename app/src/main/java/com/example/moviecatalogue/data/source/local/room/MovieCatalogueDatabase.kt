package com.example.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity

@Database(entities = [MoviesEntity::class, TvShowsEntity::class],
    version = 1,
    exportSchema = false)
abstract class MovieCatalogueDatabase : RoomDatabase() {
    abstract fun movieCatalogueDao(): MovieCatalogueDao

    companion object {

        @Volatile
        private var INSTANCE: MovieCatalogueDatabase? = null

        fun getInstance(context: Context): MovieCatalogueDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    MovieCatalogueDatabase::class.java,
                    "MovieCatalogue.db").build()
            }
    }
}