package com.example.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TvShowsEntity")
data class TvShowsEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "tvShowsId")
        var tvShowsId: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "genres")
        var genres: String,

        @ColumnInfo(name = "runtime")
        var runtime: String,

        @ColumnInfo(name = "score")
        var score: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "release")
        var release: String,

        @ColumnInfo(name = "bookmarked")
        var bookmarked: Boolean = false,

        @ColumnInfo(name = "imagePath")
        var imagePath: String
)