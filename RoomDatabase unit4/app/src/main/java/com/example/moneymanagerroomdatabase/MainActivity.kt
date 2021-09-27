package com.example.moneymanagerroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneymanagerroomdatabase.Interfaces.OnClickListener
import com.example.moneymanagerroomdatabase.models.local.TaskDAO
import com.example.moneymanagerroomdatabase.models.local.TaskExpenses
import com.example.moneymanagerroomdatabase.models.local.TaskIncome
import com.example.moneymanagerroomdatabase.models.local.TaskRoomDataBase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), OnClickListener {

    private var tasklistincome = mutableListOf<TaskIncome>()
    private var tasklistexpenses = mutableListOf<TaskExpenses>()
    lateinit var taskAdaptor: TaskAdaptor
    lateinit var taskAdaptorExpenses: TaskAdaptorExpenses
    lateinit var roomDataBase: TaskRoomDataBase
    lateinit var taskDAO: TaskDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDataBase = TaskRoomDataBase.getDataBaseObject(this)
        taskDAO = roomDataBase.getTaskDAO()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {

            var intent = Intent(this, AddActivity::class.java)
            startActivity(intent)

        }


        //income adaptor
        taskAdaptor = TaskAdaptor(this, tasklistincome, this)
        recyclerview.adapter = taskAdaptor
        recyclerview.layoutManager = LinearLayoutManager(this)

        //expenses adaptor
        taskAdaptorExpenses = TaskAdaptorExpenses(this, tasklistexpenses, this)
        recyclerview1.adapter = taskAdaptorExpenses
        recyclerview1.layoutManager = LinearLayoutManager(this)


        var income = 0.0
        var expense = 0.0

        //to add income
        taskDAO.getAllIncome().observe(this, Observer {
            if (it != null) {
                tvIncomeMoney.text = it.toString()
                income = it
                tvBalanceMoney.text = (income - expense).toString()

            } else {
                tvIncomeMoney.text = "0.0"
            }
        })

        // to add Expense
        taskDAO.getAllExpenses().observe(this, Observer {
            if (it != null) {
                tvExpensesMoney.text = it.toString()
                expense = it
                tvBalanceMoney.text = (income - expense).toString()
            } else {
                tvExpensesMoney.text = "0.0"
            }
        })

        if(income == null && expense == null ){
            tvBalanceMoney.text = "0.0"
        }

        //to live data
        taskDAO.getAllTaskincome().observe(this, Observer {
            val task = it
            CoroutineScope(Dispatchers.IO).launch {
                tasklistincome.clear()
                tasklistincome.addAll(task)
                taskAdaptor.notifyDataSetChanged()

            }
        })

        taskDAO.getAllTaskexpense().observe(this, Observer {
            val task = it

            CoroutineScope(Dispatchers.IO).launch {
                tasklistexpenses.clear()
                tasklistexpenses.addAll(task)
                taskAdaptor.notifyDataSetChanged()

            }
        })
    }


    override fun onEdit(task: TaskIncome) {


        Toast.makeText(this, "working", Toast.LENGTH_LONG).show()

        linearupdate.visibility = View.VISIBLE




        btnUpdate.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                task.title = eteditdesc.text.toString()
                task.amount = eteditamount.text.toString().toDouble()
                taskDAO.updateTaskincome(task)
            }
            linearupdate.visibility = View.GONE
        }
    }

    override fun onDelete(task: TaskIncome) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDAO.deleteTaskincome(task)
        }
    }

    override fun onEditExpense(task: TaskExpenses) {

        linearupdate.visibility = View.VISIBLE



        btnUpdate.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                task.title = eteditdesc.text.toString()
                task.amount = eteditamount.text.toString().toDouble()
                taskDAO.updateTaskexpenses(task)
            }
            linearupdate.visibility = View.GONE
        }

    }

    override fun onDeleteExpenses(task: TaskExpenses) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDAO.deleteTaskexpenses(task)
        }
    }

}