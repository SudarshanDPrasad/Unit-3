package com.example.pizzaandroid.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaandroid.R
import com.example.pizzaandroid.databinding.ItemLayoutBinding
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Response_Model
import com.example.pizzaandroid.response.Size

class PizzaAdaptor(
    val pizzaList: List<Crust>,
    val pizzasize : List<Size>
) : RecyclerView.Adapter<PizzaAdaptor.PizzaHodler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaHodler {
        val itemLayoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_layout, parent, false)
        return PizzaHodler(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: PizzaHodler, position: Int) {

        val list = pizzasize[position]
        holder.onBind(list)
        val list1 = pizzaList[position]
        holder.onBinding(list1)
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    class PizzaHodler(
        val itemLayoutBinding: ItemLayoutBinding,
    ) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun onBind(size: Size) {
            itemLayoutBinding.desc = size
        }

        fun onBinding(crust: Crust) {
            itemLayoutBinding.name = crust
        }
    }
}