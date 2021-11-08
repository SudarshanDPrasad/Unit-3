package com.application.newsbreezeapp.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.newsbreezeapp.ApiCall.Article
import com.application.newsbreezeapp.R
import com.application.newsbreezeapp.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide

class NewsAdaptor(
    val articlelist: List<Article>,
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)

        return ViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var article = articlelist[position]
        holder.onBind(article)
    }

    override fun getItemCount(): Int {
        return articlelist.size
    }
}

class ViewHolder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {
    fun onBind(article: Article) {
        itemLayoutBinding.news = article

        Glide.with(itemLayoutBinding.imageview).load(article.urlToImage)
            .into(itemLayoutBinding.imageview)
    }
}
