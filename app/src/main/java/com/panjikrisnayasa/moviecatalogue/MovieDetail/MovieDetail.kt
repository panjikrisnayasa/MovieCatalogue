package com.panjikrisnayasa.moviecatalogue.MovieDetail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.panjikrisnayasa.moviecatalogue.Model.MovieModel
import com.panjikrisnayasa.moviecatalogue.R
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity(), MovieDetailView {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movie: MovieModel = intent.getParcelableExtra(EXTRA_MOVIE)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Movie Details"

        image_movie_detail_poster.clipToOutline = true

        showMovieDetail(movie)

        button_movie_detail_buy_ticket.setOnClickListener {
            Toast.makeText(
                this,
                "You ordered \"${movie.title}\" ticket",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun showMovieDetail(movie: MovieModel) {
        Glide.with(this)
                .load(movie.poster)
                .apply(RequestOptions())
                .into(image_movie_detail_poster)
        text_movie_detail_title.text = movie.title
        text_movie_detail_genre.text = movie.genre
        text_movie_detail_duration.text = movie.duration
        text_movie_detail_rating.text = movie.rating
        text_movie_detail_rating_score.text = movie.ratingScore.toString()
        rating_movie_detail_movie.rating = movie.ratingScore / 2
        text_movie_detail_synopsis_caption.text = movie.synopsis
    }
}
