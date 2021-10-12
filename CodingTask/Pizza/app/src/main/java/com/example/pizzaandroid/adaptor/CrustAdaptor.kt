package com.example.pizzaandroid.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.R
import com.example.pizzaandroid.databinding.CrustItemLayoutBinding
import com.example.pizzaandroid.databinding.ItemLayoutBinding
import com.example.pizzaandroid.onCLiclListener.OnClickListener
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Size

class CrustAdaptor(
    val sizelist: List<Size>,
    val listener: OnClickListener,


) : RecyclerView.Adapter<CrustAdaptor.CrustHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrustHolder {
        val crustItemLayoutBinding: CrustItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.crust_item_layout, parent, false)
        return CrustHolder(crustItemLayoutBinding,listener)

    }

    override fun onBindViewHolder(holder: CrustHolder, position: Int) {
        val list = sizelist[position]
        holder.onBinding(list)

    }

    override fun getItemCount(): Int {
        return sizelist.size
    }


    class CrustHolder(
        val crustItemLayoutBinding: CrustItemLayoutBinding,
        val listener: OnClickListener,
    ) : RecyclerView.ViewHolder(crustItemLayoutBinding.root) {

        fun onBinding(size: Size) {
            crustItemLayoutBinding.size = size
            crustItemLayoutBinding.Pizzaprice.text = size.price.toString()
            crustItemLayoutBinding.click = listener
        }
    }
}
