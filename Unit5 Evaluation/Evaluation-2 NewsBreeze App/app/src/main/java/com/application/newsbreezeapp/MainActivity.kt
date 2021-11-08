package com.application.newsbreezeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.newsbreezeapp.ApiCall.Article
import com.application.newsbreezeapp.ApiCall.ResponseModel
import com.application.newsbreezeapp.adaptor.NewsAdaptor
import com.application.newsbreezeapp.viewmodel.MainUiModel
import com.application.newsbreezeapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private var list = emptyList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.callApi()
        mainViewModel.liveData.observe(this, {
            it.let {
                when (it) {
                    is MainUiModel.OnSuccess -> {
                        list = it.responseModel.articles as ArrayList<Article>
                        setRecyclerAdaptor()
                    }
                    is MainUiModel.OnFailure -> {
                        Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun setRecyclerAdaptor() {
        val newsAdaptor = NewsAdaptor(list)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerviewlist.apply {
            adapter= newsAdaptor
            layoutManager = linearLayoutManager
        }
    }
}