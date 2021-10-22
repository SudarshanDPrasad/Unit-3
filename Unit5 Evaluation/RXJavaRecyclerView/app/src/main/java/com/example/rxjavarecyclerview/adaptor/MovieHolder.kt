package com.example.rxjavarecyclerview.adaptor

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagination_recyclerview.response.Result
import com.example.rxjavarecyclerview.databinding.ItemLayoutBinding

class MovieHolder(val itemLayoutBinding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun setData(result: Result){
            itemLayoutBinding.data = result
            Glide.with(itemLayoutBinding.imageview)
                .load("https://image.tmdb.org/t/p/w500/"+result.posterPath)
                .into(itemLayoutBinding.imageview)
        }
}