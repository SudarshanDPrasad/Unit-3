package com.application.newsbreezeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.application.newsbreezeapp.adaptor.NewsAdaptor
import com.application.newsbreezeapp.adaptor.OnCardClicked
import com.application.newsbreezeapp.adaptor.OnSaveClick
import com.application.newsbreezeapp.apicall.remote.Article
import com.application.newsbreezeapp.localdb.NewsDao
import com.application.newsbreezeapp.localdb.NewsRoomDataBase
import com.application.newsbreezeapp.localdb.NewsTable
import com.application.newsbreezeapp.viewmodel.MainUiModel
import com.application.newsbreezeapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), OnCardClicked, OnSaveClick {
    private lateinit var mainViewModel: MainViewModel
    private var list = emptyList<Article>()
    lateinit var roomDataBase: NewsRoomDat aBase
    lateinit var newsDao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDataBase = NewsRoomDataBase.getDataBaseObject(this)
        newsDao = roomDataBase.getNewsDao()

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
        val newsAdaptor = NewsAdaptor(list, this, this)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerviewlist.apply {
            adapter = newsAdaptor
            layoutManager = linearLayoutManager
        }
    }

    override fun onCardClicked(article: Article) {
        val intent: Intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("author name", article.author)
        intent.putExtra("image", article.urlToImage)
        intent.putExtra("title", article.title)
        intent.putExtra("date", article.publishedAt)
        intent.putExtra("description", article.description)

        startActivity(intent)
    }

    override fun onSaveClick(article: Article) {
        Toast.makeText(this, "The Article is saved to read later ", Toast.LENGTH_SHORT).show()

        val add = NewsTable(article.publishedAt,article.title)
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.addData(add)
        }
    }
}