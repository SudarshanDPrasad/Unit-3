package com.application.newsapi.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.newsapi.R
import com.application.newsapi.clickinterface.Onclicking
import com.application.newsapi.databinding.ItemLayoutBinding
import com.application.newsapi.response.Article
import com.bumptech.glide.Glide

class NewsAdaptor(
    val list: List<Article>,
    val listener : Onclicking
) : RecyclerView.Adapter<NewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)

        return NewsHolder(itemLayoutBinding,listener)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val newsList = list[position]
        holder.setData(newsList)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class NewsHolder(
    val itemLayoutBinding: ItemLayoutBinding,
    val listener : Onclicking
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(article: Article) {
        itemLayoutBinding.newslist = article
        itemLayoutBinding.itemClickListener = listener
        Glide.with(itemLayoutBinding.IvNewsImage).load(article.urlToImage)
            .into(itemLayoutBinding.IvNewsImage)
    }
}
