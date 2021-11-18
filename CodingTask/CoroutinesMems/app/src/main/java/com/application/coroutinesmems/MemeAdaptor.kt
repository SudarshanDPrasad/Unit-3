package com.application.coroutinesmems

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.coroutinesmems.apiresponse.Meme
import com.application.coroutinesmems.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide

class MemeAdaptor(
    val memelist: List<Meme>,
) : RecyclerView.Adapter<MemeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeHolder {
        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)
        return MemeHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: MemeHolder, position: Int) {
        val meme = memelist[position]
        holder.setData(meme)
    }

    override fun getItemCount(): Int {
        return memelist.size
    }
}

class MemeHolder(
    var itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(meme: Meme) {
        itemLayoutBinding.memesTime = meme
        Glide.with(itemLayoutBinding.IvImage).load(meme.url).into(itemLayoutBinding.IvImage)
    }

}
