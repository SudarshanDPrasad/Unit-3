package com.application.moneymanager.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.moneymanager.R
import com.application.moneymanager.clickOnListener
import com.application.moneymanager.clickondelete
import com.application.moneymanager.data.ExpensesTable
import com.application.moneymanager.data.IncomeTable

class EpensesAdaptor(
    val context: Context,
    val expenseslist: MutableList<ExpensesTable>,
    val listener: clickondelete,
) : RecyclerView.Adapter<ExpensesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesHolder {
        var view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.incomerecyclerlayout, parent, false)
        return ExpensesHolder(view)
    }

    override fun onBindViewHolder(holder: ExpensesHolder, position: Int) {
        val expenses = expenseslist[position]
        holder.incomeDescription.text = expenses.Description
        holder.incomeAmount.text = expenses.Amount.toString()
        holder.dateandtime.text = expenses.Dateandtime
        holder.incomeedit.setOnClickListener {
            listener.onedit(expenses)
        }

        holder.delete.setOnClickListener {
            listener.ondelete(expenses)
        }
    }

    override fun getItemCount(): Int {
        return expenseslist.size
    }
}

class ExpensesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var incomeDescription: TextView
    var incomeAmount: TextView
    var incomeedit: Button
    var delete: Button
    var dateandtime: TextView

    init {
        incomeDescription = itemView.findViewById(R.id.tvicomedesc)
        incomeAmount = itemView.findViewById(R.id.tvincomeamount)
        incomeedit = itemView.findViewById(R.id.incomeedit)
        delete = itemView.findViewById(R.id.incomedelete)
        dateandtime = itemView.findViewById(R.id.dateandtime)

    }
}

