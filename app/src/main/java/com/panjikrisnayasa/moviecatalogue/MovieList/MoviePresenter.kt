package com.panjikrisnayasa.moviecatalogue.MovieList

class MoviePresenter(private val view: MovieView) {
    fun getListMoviesData(): ArrayList<MovieModel> {
        val list = ArrayList<MovieModel>()
        for (tData in MovieObject.moviesData) {
            val movie = MovieModel()
            movie.poster = tData[0] as Int
            movie.title = tData[1] as String
            movie.ratingScore = tData[2] as Float
            movie.genre = tData[3] as String
            movie.duration = tData[4] as String
            movie.rating = tData[5] as String
            movie.synopsis = tData[6] as String
            list.add(movie)
        }
        return list
    }
}