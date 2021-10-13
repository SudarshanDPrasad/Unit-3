package com.example.pagination_recyclerview.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.pagination_recyclerview.R
import com.example.pagination_recyclerview.response.Result
import com.example.pagination_recyclerview.databinding.ItemLayoutBinding

class MovieAdaptor : PagingDataAdapter<Result, MovieHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(
                oldItem: Result,
                newItem: Result,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Result,
                newItem: Result,
            ): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        val result = getItem(position)
        result?.let {
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)
        return MovieHolder(itemLayoutBinding)
    }
}