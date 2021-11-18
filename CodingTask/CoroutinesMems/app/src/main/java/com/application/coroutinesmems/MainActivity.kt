package com.application.coroutinesmems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.coroutinesmems.R
import com.application.coroutinesmems.apiresponse.Meme
import com.application.coroutinesmems.data.MainUIMode
import com.application.coroutinesmems.data.MemeViewModel
import com.application.coroutinesmems.databinding.ActivityMainBinding
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var memeViewModel: MemeViewModel
    private var list = emptyList<Meme>()
    lateinit var activityMainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        memeViewModel = ViewModelProvider(this).get(MemeViewModel::class.java)
        memeViewModel.callApi()
        memeViewModel.liveData.observe(this, {

            it.let {
                when (it) {
                    is MainUIMode.OnSucces -> {
                        list = it.data.data.memes as ArrayList<Meme>
                        setRecyclerAdapter()
                    }
                    is MainUIMode.OnFailure -> {
                        Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })
    }

    fun setRecyclerAdapter() {
        val mainAdapter = MemeAdaptor(list)
        val linearLayoutManager = LinearLayoutManager(this)
        activityMainBinding.recycleview.apply {
            adapter = mainAdapter
            layoutManager = linearLayoutManager
        }
    }
}