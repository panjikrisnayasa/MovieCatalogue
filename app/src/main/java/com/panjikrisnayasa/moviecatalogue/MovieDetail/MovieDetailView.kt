package com.panjikrisnayasa.moviecatalogue.MovieDetail

import com.panjikrisnayasa.moviecatalogue.Model.MovieModel

interface MovieDetailView {
    fun showMovieDetail(movie: MovieModel)
}