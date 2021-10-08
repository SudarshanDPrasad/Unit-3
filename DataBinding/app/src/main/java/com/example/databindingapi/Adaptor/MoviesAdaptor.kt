package com.example.recyclerdatabinding.Adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingapi.R
import com.example.databindingapi.databinding.ItemLayoutBinding
import com.example.databindingapi.response.IndianToon

class MoviesAdaptor(
    val movieslist: List<IndianToon>,
) : RecyclerView.Adapter<MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)
        return MovieHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val resultmodel = movieslist[position]
        holder.onBind(resultmodel)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

}

class MovieHolder(
    val itemlayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemlayoutBinding.root) {

    fun onBind(result: IndianToon) {
        itemlayoutBinding.moviesItem = result

    }

}