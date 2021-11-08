package com.application.newsbreezeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.application.newsbreezeapp.adaptor.NewsAdaptor
import com.application.newsbreezeapp.adaptor.OnCardClicked
import com.application.newsbreezeapp.apicall.remote.Article
import com.application.newsbreezeapp.viewmodel.MainUiModel
import com.application.newsbreezeapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*



class MainActivity : AppCompatActivity() , OnCardClicked{
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
        val newsAdaptor = NewsAdaptor(list,this)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerviewlist.apply {
            adapter= newsAdaptor
            layoutManager = linearLayoutManager
        }
    }

    override fun onCardClicked(article: Article) {
        val intent : Intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("author name",article.author)
        intent.putExtra("image",article.urlToImage)
        intent.putExtra("title",article.title)
        intent.putExtra("date",article.publishedAt)
        intent.putExtra("description",article.description)

        startActivity(intent)
    }
}