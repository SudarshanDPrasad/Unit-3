package com.example.moneymanagerroomdatabase.Interfaces

import com.example.moneymanagerroomdatabase.models.local.TaskExpenses
import com.example.moneymanagerroomdatabase.models.local.TaskIncome


interface OnClickListener {
    fun onEdit(task: TaskIncome)
    fun onDelete(task: TaskIncome)

    fun onEditExpense(task: TaskExpenses)
    fun onDeleteExpenses(task: TaskExpenses)

}