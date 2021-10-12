package com.example.pizzaandroid.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.R
import com.example.pizzaandroid.databinding.CrustItemLayoutBinding
import com.example.pizzaandroid.onCLiclListener.OnClickListener
import com.example.pizzaandroid.response.Size
import kotlinx.android.synthetic.main.item_layout.view.*

class CartAdaptor (
    val cartList: List<CartData>,

    ) : RecyclerView.Adapter<CartAdaptor.CartHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CartHolder(view)

    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        val list = cartList[position]
        holder.onBinding(list)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }


    class CartHolder(
        val itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {

        fun onBinding(cartData: CartData) {
            itemView.Pizza_Name.text = cartData.PizzaSize
        }
    }
}