package com.panjikrisnayasa.moviecatalogue.MovieList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.panjikrisnayasa.moviecatalogue.Model.MovieModel
import com.panjikrisnayasa.moviecatalogue.R
import kotlinx.android.synthetic.main.activity_main.*

class MovieActivity : AppCompatActivity(),
    MovieView {

    private val presenter = MoviePresenter(this)
    private val list = arrayListOf<MovieModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_main_movie.setHasFixedSize(true)
        list.addAll(presenter.getListMoviesData())
        showRecyclerView()
    }

    override fun showRecyclerView() {
        recycler_main_movie.layoutManager = LinearLayoutManager(this)
        val mainAdapter = MovieAdapter(list)
        recycler_main_movie.adapter = mainAdapter
    }
}
