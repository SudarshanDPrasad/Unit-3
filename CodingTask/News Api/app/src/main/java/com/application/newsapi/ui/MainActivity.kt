package com.application.newsapi.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.newsapi.R
import com.application.newsapi.adaptor.NewsAdaptor
import com.application.newsapi.clickinterface.Onclicking
import com.application.newsapi.data.NewsDao
import com.application.newsapi.data.NewsRoomDataBase
import com.application.newsapi.data.NewsViewModel
import com.application.newsapi.data.Status
import com.application.newsapi.databinding.ActivityMainBinding
import com.application.newsapi.response.Article
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Onclicking{

    private lateinit var activityMainBinding: ActivityMainBinding
    private var list = emptyList<Article>()
    private var newslist = mutableListOf<Article>()

    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsRoomDataBase: NewsRoomDataBase
    private lateinit var newsDao: NewsDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val connectivityManager: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        var isConnected: Boolean? = activeNetwork?.isConnectedOrConnecting
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        newsRoomDataBase = NewsRoomDataBase.getDataBaseObject(this)
        newsDao = newsRoomDataBase.getDao()
        if (isConnected == true) {
            loadApi()
        } else {
            databaseListView()
        }
    }

    private fun databaseListView() {
        Toast.makeText(this, "Network Error the Recent View List ", Toast.LENGTH_SHORT).show()
        newsViewModel.tableData().observe(this, {
            newslist.clear()
            newslist.addAll(it)
            newslist.reverse()
            val adaptor = NewsAdaptor(newslist,this)
            val layoutManager = LinearLayoutManager(this)
            activityMainBinding.NewsRecyclerView.adapter = adaptor
            activityMainBinding.NewsRecyclerView.layoutManager = layoutManager
        })
    }

    private fun loadApi() {

        newsViewModel.getDataFromApi().observe(this, {
            when (it.status) {
                Status.ERROR -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }

                Status.SUCCESS -> {
                    if (it != null) {
                        list = it.data?.articles!!
                        val adaptor = NewsAdaptor(list,this)
                        val layoutManager = LinearLayoutManager(this)
                        activityMainBinding.NewsRecyclerView.adapter = adaptor
                        activityMainBinding.NewsRecyclerView.layoutManager = layoutManager
                    }
                    newsViewModel.addData(it.data?.articles!!)
                }
            }

        })
    }

    override fun OnClick(article: Article) {
        val intent : Intent = Intent(this,OnClickActivity::class.java)
        intent.putExtra("tittle",article.title.toString())
        intent.putExtra("description",article.description.toString())
        intent.putExtra("publishDate",article.publishedAt.toString())
        intent.putExtra("URLImage",article.urlToImage)
        startActivity(intent)
    }
}