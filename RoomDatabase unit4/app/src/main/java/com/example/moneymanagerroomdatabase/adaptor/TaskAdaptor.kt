package com.example.moneymanagerroomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanagerroomdatabase.Interfaces.OnClickListener
import com.example.moneymanagerroomdatabase.models.local.TaskExpenses
import com.example.moneymanagerroomdatabase.models.local.TaskIncome

class TaskAdaptor(
    val context: Context,
    val tasklist: MutableList<TaskIncome>,
    val listener: OnClickListener,
) :
    RecyclerView.Adapter<TaskHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.task_item_row, parent, false)
        return TaskHolder(view)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val task = tasklist[position]
        holder.Description.text = task.title
        holder.Amount.text = task.amount.toString()

        holder.edittv.setOnClickListener {
            listener.onEdit(task)
        }

        holder.deletetv.setOnClickListener {
            listener.onDelete(task)
        }
    }

    override fun getItemCount(): Int {
        return tasklist.size
    }
}

class TaskHolder(view: View) : RecyclerView.ViewHolder(view) {
    var Description: TextView
    var Amount: TextView
    var edittv: TextView
    var deletetv: TextView

    init {
        Description = view.findViewById(R.id.tvDescription)
        Amount = itemView.findViewById(R.id.tvAmount)
        edittv = itemView.findViewById(R.id.editTv)
        deletetv = itemView.findViewById(R.id.deleteTv)
    }
}


// to expenses
 class TaskAdaptorExpenses(
    val context: Context,
    val tasklist: MutableList<TaskExpenses>,
    val listener: OnClickListener,
) :
    RecyclerView.Adapter<TaskHolderexpenses>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolderexpenses {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.task_item_row, parent, false)
        return TaskHolderexpenses(view)
    }

    override fun onBindViewHolder(holder: TaskHolderexpenses, position: Int) {
        val task = tasklist[position]
        holder.Description.text = task.title
        holder.Amount.text = task.amount.toString()

        holder.edittv.setOnClickListener {
            listener.onEditExpense(task)
        }

        holder.deletetv.setOnClickListener {
            listener.onDeleteExpenses(task)
        }
    }

    override fun getItemCount(): Int {
        return tasklist.size
    }
}

class TaskHolderexpenses(view: View) : RecyclerView.ViewHolder(view) {
    var Description: TextView
    var Amount: TextView
    var edittv: TextView
    var deletetv: TextView

    init {
        Description = view.findViewById(R.id.tvDescription)
        Amount = itemView.findViewById(R.id.tvAmount)
        edittv = itemView.findViewById(R.id.editTv)
        deletetv = itemView.findViewById(R.id.deleteTv)
    }
}