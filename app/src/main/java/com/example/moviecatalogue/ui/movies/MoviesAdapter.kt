package com.example.moviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.MoviesEntity
import com.example.moviecatalogue.databinding.ItemsMoviesBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity
import java.util.*


class MoviesAdapter : PagedListAdapter<MoviesEntity, MoviesAdapter.CourseViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MoviesEntity>() {
            override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsAcademyBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = getItem(position)
        if (course != null) {
            holder.bind(course)
        }
    }

    class CourseViewHolder(private val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            with(binding) {
                tvDetailTitle.text = movies.title
                tvDetailDatetime.text = itemView.resources.getString(R.string.date, movies.release_date)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_MOVIES, movies.movieId)
                    itemView.context.startActivity(intent)
                }



                Glide.with(itemView.context)
                    .load(movies.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}