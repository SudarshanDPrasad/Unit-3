package com.application.moneymanager.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.moneymanager.R
import com.application.moneymanager.adaptor.EpensesAdaptor
import com.application.moneymanager.adaptor.IncomeAdaptor
import com.application.moneymanager.clickondelete
import com.application.moneymanager.data.*
import com.application.moneymanager.dataexpenses.*
import kotlinx.android.synthetic.main.fragment_expenses.*
import kotlinx.android.synthetic.main.fragment_income.*
import kotlinx.android.synthetic.main.fragment_income.incomerecyclerview
import kotlinx.android.synthetic.main.incomedialgouelayout.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*


class Expenses : Fragment(R.layout.fragment_expenses), clickondelete {

    lateinit var roomDataBase: ExpenesesRoomDataBase
    lateinit var expensesDao: ExpensesDao
    lateinit var viewModel: ExpensesViewModel
    lateinit var incomeAdaptor: EpensesAdaptor
    var expenseslist = mutableListOf<ExpensesTable>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        roomDataBase = ExpenesesRoomDataBase.getDataBaseObject(requireContext())
        expensesDao = roomDataBase.getFeedbackDao()
        val repo = ExpensesRepo(expensesDao)
        val viewModelFactory = ExpensesViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExpensesViewModel::class.java)

        viewModel = ViewModelProviders.of(this).get(ExpensesViewModel::class.java)

        btnexpenses.setOnClickListener {
            val mDialog = LayoutInflater.from(context).inflate(R.layout.expensesdialgoue, null)
            val mBuilder = AlertDialog.Builder(activity).setView(mDialog)
            val mAlertDialog = mBuilder.show()

            mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val cal = Calendar.getInstance()
            val currentdate = DateFormat.getDateInstance().format(cal.time)
            mDialog.tvincomedate.setText(currentdate)
            mDialog.btnincomesave.setOnClickListener {
                val desc = mDialog.etincomedesc.text
                val money = mDialog.etincomeamount.text

                val save = ExpensesTable(desc.toString(), money.toString().toInt(),currentdate)
                viewModel.addExpenses(save)
                expensesDao.getAllExpenses().observe(requireActivity(), {
                    if (it != null) {
                        val sharedPreferencesprogresexpenses: SharedPreferences? =
                            context?.getSharedPreferences("Expenses", Context.MODE_PRIVATE)
                        val editor = sharedPreferencesprogresexpenses?.edit()

                        editor?.putInt("valuexpenses", it)
                        editor?.apply()
                    }
                })
                mAlertDialog.dismiss()
            }
        }


        incomeAdaptor = EpensesAdaptor(requireContext(), expenseslist,this)
        expensesrecycleview.adapter = incomeAdaptor
        expensesrecycleview.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getExpenses().observe(requireActivity(), {
            expenseslist.clear()
            expenseslist.addAll(it)
            CoroutineScope(Dispatchers.Main).launch {
                incomeAdaptor.notifyDataSetChanged()
            }
        })

    }

    override fun onedit(expensesTable: ExpensesTable) {

        linearexpenes.visibility = View.VISIBLE

        btnUpdateexpenese.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                expensesTable.Description = eteditdescexpeneses.text.toString()
                expensesTable.Amount = eteditamountexpenes.text.toString().toInt()
                expensesDao.updateexpenses(expensesTable)
            }
            linearexpenes.visibility =View.GONE
        }
    }


    override fun ondelete(expensesTable: ExpensesTable) {

        CoroutineScope(Dispatchers.IO).launch {
            expensesDao.deleteexpenses(expensesTable)
        }
    }
}