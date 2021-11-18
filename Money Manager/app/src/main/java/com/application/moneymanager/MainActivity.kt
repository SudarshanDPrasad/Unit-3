package com.application.moneymanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import com.application.moneymanager.R
import com.application.moneymanager.data.IncomeDao
import com.application.moneymanager.data.IncomeRoomDataBase
import com.application.moneymanager.data.IncomeTable
import com.application.moneymanager.dataexpenses.ExpenesesRoomDataBase
import com.application.moneymanager.dataexpenses.ExpensesDao
import com.application.moneymanager.fragments.Income
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var roomDataBase: IncomeRoomDataBase
    lateinit var incomeDao: IncomeDao
    lateinit var roomDataBaseexpenses: ExpenesesRoomDataBase
    lateinit var expensesDao: ExpensesDao
    var income = 0
    var expense = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDataBase = IncomeRoomDataBase.getDataBaseObject(this)
        incomeDao = roomDataBase.getFeedbackDao()
        roomDataBaseexpenses = ExpenesesRoomDataBase.getDataBaseObject(this)
        expensesDao = roomDataBaseexpenses.getFeedbackDao()
        setviewPagerAdaptor()
        incomeDao.getAllIncome().observe(this, {

            if (it == null) {
                incomemain.text = "0"
                income = 0
                if (expense == 0) balancemain.text = "0"
                else balancemain.text = expense.toString()
            } else {
                incomemain.text = it.toString()
                income = it

                balancemain.text = (income - expense).toString()
            }
        })
        expensesDao.getAllExpenses().observe(this, {
            if (it == null) {
                expenesmain.text = "0"
                expense = 0
                if (income == 0) balancemain.text = "0.0"
                else balancemain.text = income.toString()
            } else {
                expenesmain.text = "-$it"
                expense = it

                balancemain.text = (income - expense).toString()
            }

        })
    }

    private fun setviewPagerAdaptor() {
        val pagerAdapter = PagerAdaptor(supportFragmentManager, lifecycle)
        viewPager.setAdapter(pagerAdapter)
        TabLayoutMediator(tabLayout, viewPager
        ) { tab, position ->
            if (position == 0) {
                tab.text = "Income"
            } else if (position == 1) {
                tab.text = "Expense"
            }
        }.attach()
    }
}