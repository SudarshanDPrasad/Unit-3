package com.application.itunes2.ui

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.itunes2.data.ItunesDao
import com.application.itunes2.data.ItunesRoomDataBase
import com.application.itunes2.databinding.ActivityMainBinding
import com.application.itunes2.model.ItunesRepo
import com.application.itunes2.model.ItunesViewModel
import com.application.itunes2.model.Status
import com.application.itunessong.adaptor.SongAdaptor
import com.application.itunessong.responsemodel.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var list = emptyList<Result>()
    private var songlist = mutableListOf<Result>()
    private lateinit var itunesViewModel: ItunesViewModel
    private lateinit var itunesRepo: ItunesRepo
    private lateinit var itunesRoomDataBase: ItunesRoomDataBase
    private lateinit var itunesDao: ItunesDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val connectivityManager: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        var isConnected: Boolean? = activeNetwork?.isConnectedOrConnecting
        itunesViewModel = ViewModelProviders.of(this).get(ItunesViewModel::class.java)
        itunesRoomDataBase = ItunesRoomDataBase.getDataBaseObject(this)
        itunesDao = itunesRoomDataBase.getDao()
        activityMainBinding.btnsearch.setOnClickListener {
            if (isConnected == true) {
                searchView()
            } else {
                databaseListView()
            }
        }
    }

    private fun databaseListView() {
        Toast.makeText(this, "Network Error the Recent View List ", Toast.LENGTH_SHORT).show()
        itunesViewModel.songsfromDb(activityMainBinding.floatingSearchView.text.toString()).observe(this, {
            songlist.clear()
            songlist.addAll(it)
            songlist.reverse()
            val adaptor = SongAdaptor(songlist)
            val layoutManager = LinearLayoutManager(this)
            activityMainBinding.RecyclerViewSongList.adapter = adaptor
            activityMainBinding.RecyclerViewSongList.layoutManager = layoutManager
        })
    }

    private fun searchView() {
        activityMainBinding.floatingSearchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0 != null) {
                    loaddata(p0.toString())
                }
            }
        })
    }


    private fun loaddata(newQuery: String) {

        itunesViewModel.getData(newQuery).observe(this, {
            when (it.status) {
                Status.ERROR -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }

                Status.SUCCESS -> {
                    list = it.data?.result!!
                    val adaptor = SongAdaptor(list)
                    val layoutManager = LinearLayoutManager(this)
                    activityMainBinding.RecyclerViewSongList.adapter = adaptor
                    activityMainBinding.RecyclerViewSongList.layoutManager = layoutManager


                    itunesViewModel.addApiData(it.data.result)
                }
            }
        })
    }
}