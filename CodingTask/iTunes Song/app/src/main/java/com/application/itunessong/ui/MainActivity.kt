package com.application.itunessong.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.itunessong.adaptor.SongAdaptor
import com.application.itunessong.data.SongViewModel
import com.application.itunessong.data.Status
import com.application.itunessong.databinding.ActivityMainBinding
import com.application.itunessong.responsemodel.Result
import com.application.itunessong.roomdatabase.SongDao
import com.application.itunessong.roomdatabase.SongDataBase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var list = emptyList<Result>()
    private lateinit var songViewModel: SongViewModel
    lateinit var songDao: SongDao
    lateinit var songDataBase: SongDataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        songViewModel = ViewModelProviders.of(this).get(SongViewModel::class.java)
        songDataBase = SongDataBase.getDataBaseObject(this)
        songDao = songDataBase.getSongDao()

        activityMainBinding.floatingSearchView.setOnQueryChangeListener { oldQuery, newQuery ->
            loadapi(newQuery)
        }
    }

    private fun loadapi(query: String) {

//        songViewModel.liveData.observe(this, {
//            it.let {
//                when (it){
//                    is MainUiModel.OnSuccess ->{
//                        list = it.responseDTO.resultModels
//                    val adaptor = SongAdaptor(list)
//                    val layoutManager = LinearLayoutManager(this)
//                    activityMainBinding.RecyclerViewSongList.adapter = adaptor
//                    activityMainBinding.RecyclerViewSongList.layoutManager = layoutManager
//                    }
//                    is MainUiModel.OnFailure ->{
//                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        })
//        songViewModel.getData(query)

        songViewModel.getData(query).observe(this, {
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

                    songViewModel.getAPi(it.data.result)
                }
            }
        })

    }

//    override fun add(result: Result) {
//        Toast.makeText(this, "Song Added to DataBase", Toast.LENGTH_SHORT).show()
//       val add = SongStorage(result.trackName, result.artistName, result.previewUrl)
//        CoroutineScope(Dispatchers.IO).launch {
//            songDao.addSong(add)
//        }
//    }
}