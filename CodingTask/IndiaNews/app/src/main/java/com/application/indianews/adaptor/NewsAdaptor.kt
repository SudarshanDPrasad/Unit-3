package com.application.indianews.adaptor

import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.indianews.R
import com.application.indianews.databinding.ItemLayoutBinding
import com.application.indianews.reponse.Data
import com.bumptech.glide.Glide

class NewsAdaptor(
    val list: List<Data>,
) : RecyclerView.Adapter<NewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {

        val itemLayoutBinding : ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_layout,parent,false)

        return NewsHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val NewsList = list[position]
        holder.setData(NewsList)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class NewsHolder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(data: Data) {
        itemLayoutBinding.newsShort = data
        Glide.with(itemLayoutBinding.IvNewsImage).load(data.images)
            .into(itemLayoutBinding.IvNewsImage)
    }
}