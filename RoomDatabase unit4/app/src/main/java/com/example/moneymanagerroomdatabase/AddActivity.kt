package com.example.moneymanagerroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.moneymanagerroomdatabase.models.local.TaskDAO
import com.example.moneymanagerroomdatabase.models.local.TaskExpenses
import com.example.moneymanagerroomdatabase.models.local.TaskIncome
import com.example.moneymanagerroomdatabase.models.local.TaskRoomDataBase
import com.example.moneymanagerroomdatabase.repository.TaskRepo
import com.example.moneymanagerroomdatabase.viewmodels.TaskViewModel
import com.example.roomdatabase.models.responses.CreateTaskRequestModel
import com.example.roomdatabase.viewmodels.TaskViewModelFactory
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    lateinit var roomDataBase: TaskRoomDataBase
    lateinit var taskDAO: TaskDAO
    lateinit var viewmodel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        roomDataBase = TaskRoomDataBase.getDataBaseObject(this)
        taskDAO = roomDataBase.getTaskDAO()


        val repo = TaskRepo(taskDAO)
        val viewModelFactory = TaskViewModelFactory(repo)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(TaskViewModel::class.java)

        btnincome.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            var adding = TaskIncome(tvIncomeDesc.text.toString(), tvIncomeAmount.text.toString().toDouble(),"Income")


            val createTaskRequestModel = CreateTaskRequestModel(
                description = tvIncomeDesc.text.toString(),
                status = tvIncomeAmount.text.toString().toDouble().toInt(),
                title = "Income")


            viewmodel.createNewTask(createTaskRequestModel)


            CoroutineScope(Dispatchers.IO).launch {
                taskDAO.addTaskincome(adding)
            }
            startActivity(intent)

        }

        btnExpenses.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            var adding = TaskExpenses(tvExpensesDesc.text.toString(), tvExpenseAmount.text.toString().toDouble(),"Expenses")


            CoroutineScope(Dispatchers.IO).launch {
                taskDAO.addTaskexpenses(adding)
            }
            startActivity(intent)

        }
    }
}