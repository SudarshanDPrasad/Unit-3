package com.example.moneymanagerroomdatabase.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasksincome")
data class TaskIncome(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "amount") var amount: Double,
    @ColumnInfo(name = "type") var type: String,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}


@Entity(tableName = "tasksexpenes")
data class TaskExpenses(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "amount") var amount: Double,
    @ColumnInfo(name = "type") var type: String,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}