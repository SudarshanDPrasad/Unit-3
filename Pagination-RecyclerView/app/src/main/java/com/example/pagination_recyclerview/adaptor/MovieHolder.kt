package com.example.pagination_recyclerview.adaptor

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagination_recyclerview.response.Result
import com.example.pagination_recyclerview.databinding.ItemLayoutBinding

class MovieHolder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(result: Result) {
        itemLayoutBinding.result = result
        Glide.with(itemLayoutBinding.imageView).load("https://image.tmdb.org/t/p/w500/"+result.posterPath)
            .into(itemLayoutBinding.imageView)
    }
}