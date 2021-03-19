package com.example.moviecatalogue.utils

import android.content.Context
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowsResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("movie.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)

                val movieId = course.getString("movieId")
                val title = course.getString("title")
                val release_date = course.getString("release_date")
                val release = course.getString("release")
                val genres = course.getString("genres")
                val runtime = course.getString("runtime")
                val score = course.getString("score")
                val tagline = course.getString("tagline")
                val description = course.getString("description")
                val imagePath = course.getString("imagePath")

                val movieResponse = MovieResponse(
                    movieId, title, release_date, release, genres, runtime, score, tagline, description, imagePath
                )
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShows(): List<TvShowsResponse> {
        val list = ArrayList<TvShowsResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("tv_shows.json").toString())
            val listArray = responseObject.getJSONArray("tv_shows")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)

                val tvShowsId = course.getString("tvShowsId")
                val title = course.getString("title")
                val genres = course.getString("genres")
                val runtime = course.getString("runtime")
                val score = course.getString("score")
                val description = course.getString("description")
                val release = course.getString("release")
                val imagePath = course.getString("imagePath")

                val tvShowsResponse = TvShowsResponse(
                    tvShowsId, title, genres, runtime, score, description, release, imagePath
                )
                list.add(tvShowsResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }


}