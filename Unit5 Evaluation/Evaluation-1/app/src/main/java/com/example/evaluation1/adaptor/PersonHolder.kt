package com.example.evaluation1.adaptor

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evaluation1.databinding.ItemLayoutBinding
import com.example.evaluation1.response.ResponseModelItem

class PersonHolder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(responseModelItem: ResponseModelItem){
        itemLayoutBinding.details = responseModelItem
        Glide.with(itemLayoutBinding.imageView).load(responseModelItem.image.original).into(itemLayoutBinding.imageView)
    }
}