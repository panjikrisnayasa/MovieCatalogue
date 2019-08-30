package com.panjikrisnayasa.moviecatalogue.MovieList

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.panjikrisnayasa.moviecatalogue.Model.MovieModel
import com.panjikrisnayasa.moviecatalogue.MovieDetail.MovieDetail
import com.panjikrisnayasa.moviecatalogue.R

class MovieAdapter(private var listMovie: ArrayList<MovieModel>) :
    RecyclerView.Adapter<MovieAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_main_movie, parent, false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val (poster, title, ratingScore, genre, duration, rating, synopsis) = listMovie[position]

        holder.mImagePoster.clipToOutline = true

        Glide.with(holder.itemView.context)
            .load(poster)
            .apply(RequestOptions())
            .into(holder.mImagePoster)

        holder.mTextTitle.text = title
        holder.mRatingMovie.rating = ratingScore / 2
        holder.mTextRatingScore.text = ratingScore.toString()
        holder.mTextGenre.text = genre
        holder.mTextDuration.text = duration
        holder.mTextRating.text = rating

        holder.mButtonDetails.setOnClickListener {
            moveToMovieDetail(poster, title, ratingScore, genre, duration, rating, synopsis, it)
        }
        holder.itemView.setOnClickListener {
            moveToMovieDetail(poster, title, ratingScore, genre, duration, rating, synopsis, it)
        }
    }

    private fun moveToMovieDetail(
        poster: Int,
        title: String?,
        ratingScore: Float,
        genre: String?,
        duration: String?,
        rating: String?,
        synopsis: String?,
        it: View
    ) {
        val movieDetail = MovieModel()
        movieDetail.poster = poster
        movieDetail.title = title
        movieDetail.ratingScore = ratingScore
        movieDetail.genre = genre
        movieDetail.duration = duration
        movieDetail.rating = rating
        movieDetail.synopsis = synopsis

        val movieDetailIntent = Intent(it.context, MovieDetail::class.java)
        movieDetailIntent.putExtra(MovieDetail.EXTRA_MOVIE, movieDetail)
        it.context.startActivity(movieDetailIntent)
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImagePoster: ImageView =
            itemView.findViewById(R.id.image_item_recycler_main_movie_poster)
        var mTextTitle: TextView = itemView.findViewById(R.id.text_item_recycler_main_movie_title)
        var mRatingMovie: RatingBar = itemView.findViewById(R.id.rating_item_recycler_main_movie)
        var mTextRatingScore: TextView =
            itemView.findViewById(R.id.text_item_recycler_main_movie_rating_score)
        var mTextGenre: TextView = itemView.findViewById(R.id.text_item_recycler_main_movie_genre)
        var mTextDuration: TextView =
            itemView.findViewById(R.id.text_item_recycler_main_movie_duration)
        var mTextRating: TextView = itemView.findViewById(R.id.text_item_recycler_main_movie_rating)
        var mButtonDetails: TextView =
            itemView.findViewById(R.id.button_item_recycler_main_movie_details)
    }
}