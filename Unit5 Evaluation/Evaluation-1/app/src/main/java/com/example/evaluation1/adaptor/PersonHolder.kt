package com.example.evaluation1.adaptor

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evaluation1.databinding.ItemLayoutBinding
import com.example.evaluation1.response.ResponseModelItem

class PersonHolder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(responseModelItem: ResponseModelItem) {
        itemLayoutBinding.details = responseModelItem
        try {
            Glide.with(itemLayoutBinding.imageView).load(responseModelItem.image.original)
                .into(itemLayoutBinding.imageView)
        } catch (expection:Exception){

        }

        if(responseModelItem.deathday!=null){
            itemLayoutBinding.card.visibility = View.VISIBLE
        }else {
            itemLayoutBinding.card.visibility = View.GONE
        }
    }
}