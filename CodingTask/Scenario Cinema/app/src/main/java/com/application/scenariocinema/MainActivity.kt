package com.application.scenariocinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.application.scenariocinema.apiresources.OnClick
//import com.application.scenariocinema.adaptor.MovieFrontAdaptor
import com.application.scenariocinema.data.MovieViewModel
import com.application.scenariocinema.pagination.PaginationAdaptor
import com.application.scenariocinema.responseonemore.Result
import com.application.scenariocinema.ui.main.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnClick {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdaptor: PaginationAdaptor

    private var list = emptyList<com.application.scenariocinema.responseonemore.Result>()
//private var movieroomdataBase : MovieRoomDataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refresh()
    }

    private fun refresh() {

        Refresh_Scrool.setOnRefreshListener {
            movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
            setRecyclerAdaptor()

            movieViewModel.callApi().observe(this, { it ->
                if (it != null) {
                    Refresh_Scrool.isRefreshing = false
                    CoroutineScope(Dispatchers.Main).launch {
                        movieAdaptor.submitData(it)
                    }
                }

            })

            Toast.makeText(this, "Recycler Updated", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setRecyclerAdaptor() {
        movieAdaptor = PaginationAdaptor(this)
        val linearLayoutManager = GridLayoutManager(this, 2)
        recyclerviewlist.apply {
            adapter = movieAdaptor
            layoutManager = linearLayoutManager
        }
    }

    override fun onClickCardView(result: Result?) {
//        Toast.makeText(this, "On Click is Working ", Toast.LENGTH_SHORT).show()
        var intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("image", "https://image.tmdb.org/t/p/w500/" + result?.posterPath)
        intent.putExtra("Language", result?.originalLanguage)
        intent.putExtra("Generes", result?.genreIds.toString())
        intent.putExtra("realeaseDate", result?.releaseDate)
        startActivity(intent)
    }
}