package com.example.recyclerdatabinding.Adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.databindingmvvm.R
import com.example.databindingmvvm.databinding.ItemLayoutBinding
import com.example.databindingmvvm.response.IndianToon
import com.example.databindingmvvm.response.Result

class MoviesAdaptor(
    val movieslist: MutableList<IndianToon>,
) : RecyclerView.Adapter<MoviesAdaptor.MovieHolder>() {
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


    class MovieHolder(
        val itemlayoutBinding: ItemLayoutBinding,
    ) : RecyclerView.ViewHolder(itemlayoutBinding.root) {

        fun onBind(result: IndianToon) {
            itemlayoutBinding.moviesItem = result
            Glide.with(itemlayoutBinding.imageView)
                .load(result.image)
                .into(itemlayoutBinding.imageView)
        }

    }
}

