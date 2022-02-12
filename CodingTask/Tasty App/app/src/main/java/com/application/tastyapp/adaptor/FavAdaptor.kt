package com.application.tastyapp.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.application.tastyapp.R
import com.application.tastyapp.databinding.MainscreenItemLayoutBinding
import com.application.tastyapp.response.model.data.favdata.FavTable
import com.bumptech.glide.Glide

class FavAdaptor(
    private val foodList: List<FavTable>,
) :
    RecyclerView.Adapter<TastyFavHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TastyFavHolder {
        val mainScreenBinding: MainscreenItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.mainscreen_item_layout, parent, false)

        return TastyFavHolder(mainScreenBinding)
    }

    override fun onBindViewHolder(holder: TastyFavHolder, position: Int) {
        holder.setData(foodList[position])
        holder.mainScreenBinding.rvToClick.setOnClickListener{
            Toast.makeText(holder.mainScreenBinding.rvToClick.context, "Search in the Main for the recipe ", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

}

class TastyFavHolder(
    var mainScreenBinding: MainscreenItemLayoutBinding,
) : RecyclerView.ViewHolder(mainScreenBinding.root) {
    fun setData(favTable: FavTable) {

        Glide.with(mainScreenBinding.ivMainLayout).load(favTable.thumbnailUrl)
            .into(mainScreenBinding.ivMainLayout)
        mainScreenBinding.TvNameOfMainLayout.text = favTable.name

    }
}