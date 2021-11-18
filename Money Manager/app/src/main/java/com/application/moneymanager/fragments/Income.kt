package com.application.moneymanager.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.moneymanager.R
import com.application.moneymanager.adaptor.IncomeAdaptor
import com.application.moneymanager.clickOnListener
import com.application.moneymanager.data.*
import kotlinx.android.synthetic.main.fragment_income.*
import kotlinx.android.synthetic.main.incomedialgouelayout.*
import kotlinx.android.synthetic.main.incomedialgouelayout.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.text.DateFormat
import java.time.Month
import java.time.Year
import java.util.*


class Income : Fragment(R.layout.fragment_income), clickOnListener {
    lateinit var roomDataBase: IncomeRoomDataBase
    lateinit var incomeDao: IncomeDao
    lateinit var viewModel: IncomeViewModel
    lateinit var incomeAdaptor: IncomeAdaptor
    var incomelist = mutableListOf<IncomeTable>()
    var total: Int = 0;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        roomDataBase = IncomeRoomDataBase.getDataBaseObject(requireContext())
        incomeDao = roomDataBase.getFeedbackDao()
        val repo = IncomeRepo(incomeDao)
        val viewModelFactory = IncomeViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(IncomeViewModel::class.java)

        viewModel = ViewModelProviders.of(this).get(IncomeViewModel::class.java)

        btnincome.setOnClickListener {
            val mDialog = LayoutInflater.from(context).inflate(R.layout.incomedialgouelayout, null)
            val mBuilder = AlertDialog.Builder(activity).setView(mDialog)
            val mAlertDialog = mBuilder.show()

            mAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val cal = Calendar.getInstance()
            val currentdate = DateFormat.getDateInstance().format(cal.time)
            mDialog.tvincomedate.setText(currentdate)
            mDialog.btnincomesave.setOnClickListener {
                val desc = mDialog.etincomedesc.text
                val money = mDialog.etincomeamount.text

                val save = IncomeTable(desc.toString(), money.toString().toInt(),currentdate)
                viewModel.addIncome(save)
                mAlertDialog.dismiss()
            }
        }


        incomeAdaptor = IncomeAdaptor(requireContext(), incomelist, this)
        incomerecyclerview.adapter = incomeAdaptor
        incomerecyclerview.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getIncome().observe(requireActivity(), {
            incomelist.clear()
            incomelist.addAll(it)
            CoroutineScope(Dispatchers.Main).launch {
                incomeAdaptor.notifyDataSetChanged()
            }
        })

        incomeDao.getAllIncome().observe(requireActivity(), {
            if (it != null) {
                val sharedPreferencesprogres: SharedPreferences? =
                    context?.getSharedPreferences("Income", MODE_PRIVATE)
                val editor = sharedPreferencesprogres?.edit()

                editor?.putInt("valueprogress", it)
                editor?.apply()
            }
        })

    }

    override fun onedit(incomeTable: IncomeTable) {

        linearupdate.visibility = View.VISIBLE

        btnUpdate.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                incomeTable.Description = eteditdesc.text.toString()
                incomeTable.Amount = eteditamount.text.toString().toInt()
                incomeDao.updateincome(incomeTable)
            }
            linearupdate.visibility =View.GONE
        }
    }

    override fun ondelete(incomeTable: IncomeTable) {
        CoroutineScope(Dispatchers.IO).launch {
            incomeDao.deleteIncome(incomeTable)
        }
    }
}