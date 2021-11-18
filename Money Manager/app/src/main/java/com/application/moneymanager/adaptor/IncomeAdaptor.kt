package com.application.moneymanager.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.application.moneymanager.R
import com.application.moneymanager.clickOnListener
import com.application.moneymanager.data.IncomeTable
import org.w3c.dom.Text

class IncomeAdaptor(
    val context: Context,
    val incomelist: MutableList<IncomeTable>,
    val listener: clickOnListener,
) : RecyclerView.Adapter<IncomeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeHolder {
        var view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.incomerecyclerlayout, parent, false)
        return IncomeHolder(view)
    }

    override fun onBindViewHolder(holder: IncomeHolder, position: Int) {
        val income = incomelist[position]
        holder.incomeDescription.text = income.Description
        holder.incomeAmount.text = income.Amount.toString()
        holder.dateandtime.text = income.Dateandtime
        holder.incomeedit.setOnClickListener {
            listener.onedit(income)
        }

        holder.delete.setOnClickListener {
            listener.ondelete(income)
        }
    }

    override fun getItemCount(): Int {
        return incomelist.size
    }
}

class IncomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var incomeDescription: TextView
    var incomeAmount: TextView
    var incomeedit: Button
    var delete: Button
    var dateandtime: TextView

    init {
        incomeDescription = itemView.findViewById(R.id.tvicomedesc)
        incomeAmount = itemView.findViewById(R.id.tvincomeamount)
        dateandtime = itemView.findViewById(R.id.dateandtime)
        incomeedit = itemView.findViewById(R.id.incomeedit)
        delete = itemView.findViewById(R.id.incomedelete)
    }
}
