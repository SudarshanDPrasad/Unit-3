package com.application.newsbreezeapp.adaptor

import androidx.recyclerview.widget.RecyclerView
import com.application.newsbreezeapp.apicall.remote.Article
import com.application.newsbreezeapp.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide

class NewsHolder(
    val itemLayoutBinding: ItemLayoutBinding,
    private val onCardClicked: OnCardClicked,
    private val onSaveClick: OnSaveClick
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(article: Article) {
        itemLayoutBinding.itemClickListener = onCardClicked
        itemLayoutBinding.article = article
        itemLayoutBinding.saveclicklistener = onSaveClick


        Glide.with(itemLayoutBinding.imageview).load(article.urlToImage).into(itemLayoutBinding.imageview)
    }
}