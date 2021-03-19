package com.example.moviecatalogue.ui.fav.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.TvShowsEntity
import com.example.moviecatalogue.databinding.ItemsTvShowsBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity
import java.util.*


class TvShowsBookmarkAdapter : PagedListAdapter<TvShowsEntity, TvShowsBookmarkAdapter.CourseViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowsEntity>() {
            override fun areItemsTheSame(oldItem: TvShowsEntity, newItem: TvShowsEntity): Boolean {
                return oldItem.tvShowsId == newItem.tvShowsId
            }
            override fun areContentsTheSame(oldItem: TvShowsEntity, newItem: TvShowsEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemsAcademyBinding = ItemsTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = getItem(position)
        if (course != null) {
            holder.bind(course)
        }
    }

    class CourseViewHolder(private val binding: ItemsTvShowsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: TvShowsEntity) {
            with(binding) {
                tvDetailTitle.text = movies.title
                tvDetailDatetime.text = itemView.resources.getString(R.string.date, movies.release)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_TV_SHOWS, movies.tvShowsId)
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