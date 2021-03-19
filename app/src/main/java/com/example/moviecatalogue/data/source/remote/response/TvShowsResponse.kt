package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class TvShowsResponse (
    var tvShowsId: String,
    var title: String,
    var genres: String,
    var runtime: String,
    var score: String,
    var description: String,
    var release: String,
    var imagePath: String
    ): Parcelable