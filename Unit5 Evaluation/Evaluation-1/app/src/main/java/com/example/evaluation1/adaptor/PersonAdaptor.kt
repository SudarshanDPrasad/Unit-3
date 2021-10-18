package com.example.evaluation1.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.evaluation1.R
import com.example.evaluation1.databinding.ItemLayoutBinding
import com.example.evaluation1.response.ResponseModelItem

class PersonAdaptor : PagingDataAdapter<ResponseModelItem, PersonHolder>(diffUtil) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResponseModelItem>() {
            override fun areItemsTheSame(
                oldItem: ResponseModelItem,
                newItem: ResponseModelItem,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponseModelItem,
                newItem: ResponseModelItem,
            ): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val result = getItem(position)
        result?.let {
            if(!(it.deathday == null && it.birthday == null )
            ) {
                holder.setData(it)
            }else {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {

        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)
        return PersonHolder(itemLayoutBinding)
    }
}