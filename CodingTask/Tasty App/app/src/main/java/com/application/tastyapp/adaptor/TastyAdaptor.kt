package com.example.tasty.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.tastyapp.R
import com.application.tastyapp.databinding.MainscreenItemLayoutBinding
import com.application.tastyapp.response.model.frontScreen.ItemX
import com.application.tastyapp.response.onClick.onClickListener
import com.bumptech.glide.Glide

class TastyAdaptor(
    private val foodList: ArrayList<ItemX>,
    val onClickListener: onClickListener
) :
    RecyclerView.Adapter<TastyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TastyHolder {
        val mainScreenBinding: MainscreenItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.mainscreen_item_layout, parent, false)

        return TastyHolder(mainScreenBinding,onClickListener)
    }

    override fun onBindViewHolder(holder: TastyHolder, position: Int) {
        holder.setData(foodList[position])

        holder.mainScreenBinding.ivMainLayout.setOnClickListener{
            onClickListener.onClickOfView(foodList[position])
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

}

class TastyHolder(
    var mainScreenBinding: MainscreenItemLayoutBinding,
    val onClickListener: onClickListener,
) : RecyclerView.ViewHolder(mainScreenBinding.root) {
    fun setData(itemX: ItemX) {

        Glide.with(mainScreenBinding.ivMainLayout).load(itemX.thumbnailUrl)
            .into(mainScreenBinding.ivMainLayout)
        mainScreenBinding.TvNameOfMainLayout.text = itemX.name

    }
}