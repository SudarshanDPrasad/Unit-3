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

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
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

/*

What is a RecyclerView?
RecyclerView is the ViewGroup that contains the views corresponding to your data

Scrap (view): A child view that has entered into a temporarily detached state during layout.
              Scrap views may be reused without becoming fully detached from the parent RecyclerView,
              either unmodified if no rebinding is required or modified by the adapter
              if the view was considered dirty.


Dirty (view): A child view that must be rebound by the adapter before being displayed.
 */