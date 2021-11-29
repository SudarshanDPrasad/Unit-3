package com.application.scenariocinema.pagination

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.scenariocinema.R
import com.application.scenariocinema.apiresources.OnClick
import com.application.scenariocinema.databinding.ItemLayoutBinding
import com.application.scenariocinema.responseonemore.Result
import com.bumptech.glide.Glide
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class PaginationAdaptor(
    val listener: OnClick,
) : PagingDataAdapter<Result, PaginationHolder>(diffUtil) {

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

    override fun onBindViewHolder(holder: PaginationHolder, position: Int) {
        val result = getItem(position)
        result?.let {
            holder.setData(it)
        }

        holder.itemLayoutBinding.cardView.setOnClickListener {
            listener.onClickCardView(result)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaginationHolder {
        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)
        return PaginationHolder(itemLayoutBinding)
    }
}

class PaginationHolder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(result: Result) {
        itemLayoutBinding.moviesItem = result
        Glide.with(itemLayoutBinding.IvBackgroundImage)
            .load("https://image.tmdb.org/t/p/w500/" + result.posterPath)
            .into(itemLayoutBinding.IvBackgroundImage)
    }

}