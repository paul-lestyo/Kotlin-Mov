package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var title: String,
    var release_date: String,
    var release: String,
    var genres: String,
    var runtime: String,
    var score: String,
    var tagline: String,
    var description: String,
    var imagePath: String
): Parcelable