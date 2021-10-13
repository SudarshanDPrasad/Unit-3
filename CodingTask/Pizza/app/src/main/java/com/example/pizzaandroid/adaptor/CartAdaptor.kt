package com.example.pizzaandroid.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.R
import com.example.pizzaandroid.databinding.CartDataLayoutBinding
import com.example.pizzaandroid.databinding.CrustItemLayoutBinding
import com.example.pizzaandroid.onCLiclListener.OnClickListener
import com.example.pizzaandroid.onCLiclListener.OnDeleteListener
import com.example.pizzaandroid.response.Size
import kotlinx.android.synthetic.main.cart_data_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class CartAdaptor(
    val cartList: List<CartData>,
    val listener: OnDeleteListener,

    ) : RecyclerView.Adapter<CartAdaptor.CartHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val cartDataLayoutBinding: CartDataLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.cart_data_layout, parent, false)
        return CartHolder(cartDataLayoutBinding, listener)

    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        val list = cartList[position]
        holder.onBinding(list)

        holder.cartDataLayoutBinding.deleteitem.setOnClickListener {
            listener.onDelete(list)
        }

        holder.cartDataLayoutBinding.addextra.setOnClickListener {
            listener.onAddExtra(list)
        }
    }

    override fun getItemCount(): Int {
        return cartList.size
    }


    class CartHolder(
        val cartDataLayoutBinding: CartDataLayoutBinding,
        val listener: OnDeleteListener
    ) : RecyclerView.ViewHolder(cartDataLayoutBinding.root) {

        fun onBinding(cartData: CartData) {
            cartDataLayoutBinding.Pizzadataname.text = cartData.PizzaName
            cartDataLayoutBinding.Pizzadatasize.text = cartData.PizzaSize
            cartDataLayoutBinding.Pizzadataprice.text = "Total amount =  " + cartData.PizzaPrice.toString()
            cartDataLayoutBinding.Pizzadataquantity.text =
                "Total Quantity =  " + cartData.PizzaQunatity.toString()
            cartDataLayoutBinding.delete = listener
        }
    }
}