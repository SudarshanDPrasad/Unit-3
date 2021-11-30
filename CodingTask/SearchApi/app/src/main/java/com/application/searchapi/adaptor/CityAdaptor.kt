package com.application.searchapi.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.searchapi.R
import com.application.searchapi.databinding.ItemLayoutBinding
import com.application.searchapi.response.Address

class CityAdaptor(
    val list: List<Address>,
) : RecyclerView.Adapter<CityHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {

        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)
        return CityHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val City_List = list[position]
        holder.setData(City_List)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class CityHolder(
    val itemLayoutBinding: ItemLayoutBinding,
) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(address: Address) {
        itemLayoutBinding.nameCity = address
    }

}
