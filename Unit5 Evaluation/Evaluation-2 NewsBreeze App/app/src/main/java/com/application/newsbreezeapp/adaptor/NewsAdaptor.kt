package com.application.newsbreezeapp.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.newsbreezeapp.R
import com.application.newsbreezeapp.apicall.remote.Article
import com.application.newsbreezeapp.databinding.ItemLayoutBinding

class NewsAdaptor(
    val articlelist: List<Article>,
    private val itemClickListener: OnCardClicked
) : RecyclerView.Adapter<NewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)

        return NewsHolder(itemLayoutBinding,itemClickListener)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        var article = articlelist[position]
        holder.setData(article)
    }

    override fun getItemCount(): Int {
        return articlelist.size
    }
}

