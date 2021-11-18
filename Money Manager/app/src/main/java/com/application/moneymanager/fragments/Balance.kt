package com.application.moneymanager.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.moneymanager.R
import kotlinx.android.synthetic.main.fragment_balance.*


class Balance : Fragment(R.layout.fragment_balance) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = context?.getSharedPreferences("Income",Context.MODE_PRIVATE)
        val income = sharedPreferences?.getInt("valueprogress",0)
        incomeshow.setText(income.toString())

        val sharedPreferencesprogresexpenses = context?.getSharedPreferences("Expenses",Context.MODE_PRIVATE)
        val expenses = sharedPreferencesprogresexpenses?.getInt("valuexpenses",0)
        expenseshow.setText(expenses.toString())

        val total = income?.toInt()?.minus(expenses?.toInt()!!)
        totalshow.setText(total.toString())
    }
}