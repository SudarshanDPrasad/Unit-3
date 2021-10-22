package com.example.rxjavarecyclerview.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.pagination_recyclerview.response.Result
import com.example.rxjavarecyclerview.R
import com.example.rxjavarecyclerview.databinding.ItemLayoutBinding

class MovieAdaptor : PagingDataAdapter<Result, MovieHolder>(diffUtil) {

    private lateinit var itemLayoutBinding: ItemLayoutBinding

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {

                return oldItem.equals(newItem)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        itemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)
        return MovieHolder(itemLayoutBinding)
    }
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        var response = getItem(position)
        response?.let {
            holder.setData(it)
        }
    }
}