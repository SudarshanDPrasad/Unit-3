package com.application.tastyapp.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.tastyapp.R
import com.application.tastyapp.databinding.NestedRvItemLayoutBinding
import com.application.tastyapp.response.model.frontScreen.ItemX
import com.application.tastyapp.response.model.frontScreen.ResultModel
import com.application.tastyapp.response.onClick.onClickListener
import com.example.tasty.view.adapters.TastyAdaptor


class RecyclerViewAdapter(
    private val responseList: ArrayList<ResultModel>,
    val onClickListener: onClickListener

    ) :
    RecyclerView.Adapter<MainRvViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvViewHolder {

        val itemLayoutBinding: NestedRvItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.nested_rv_item_layout, parent, false)

        return MainRvViewHolder(itemLayoutBinding,onClickListener)
    }

    override fun onBindViewHolder(holder: MainRvViewHolder, position: Int) {
        val data = responseList[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }
}

class MainRvViewHolder(
    private val nestedRvItemLayoutBinding: NestedRvItemLayoutBinding,
    val onClickListener: onClickListener,
) :
    RecyclerView.ViewHolder(nestedRvItemLayoutBinding.root) {


    fun setData(resultModel: ResultModel) {

        nestedRvItemLayoutBinding.TvThemeName.text = resultModel.name
        if (resultModel.items != null)
            nestedRvItemLayoutBinding.nestedRecyclerView.apply {
                adapter = TastyAdaptor(
                    resultModel.items as ArrayList<ItemX>,
                    onClickListener)
                layoutManager = LinearLayoutManager(
                    itemView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            }

    }
}
