package com.application.contactreadapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class PaginAdaptor(
    val listener: onCLick,
) : PagingDataAdapter<ContactTable, PagingHolder>(diffutil) {

    companion object {
        val diffutil = object : DiffUtil.ItemCallback<ContactTable>() {
            override fun areItemsTheSame(oldItem: ContactTable, newItem: ContactTable): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ContactTable, newItem: ContactTable): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: PagingHolder, position: Int) {
        val result = getItem(position)
        result?.let {
            holder.setData(it)

            holder.itemping.cardView.setOnClickListener {
                listener.OnCardclick(result)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return PagingHolder(view)
    }



}

class PagingHolder(
    val itemping: View,
) : RecyclerView.ViewHolder(itemping) {

    fun setData(contactDto: ContactTable) {
        itemping.Tv_Name.setText(contactDto.Name)
        itemping.Tv_Number.setText(contactDto.Number)
    }

}
