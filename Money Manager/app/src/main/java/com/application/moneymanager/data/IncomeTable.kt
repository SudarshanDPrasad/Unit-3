package com.application.moneymanager.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Income")
data class IncomeTable(
    @ColumnInfo(name = "Description") var Description: String,
    @ColumnInfo(name = "Amount") var Amount: Int,
    @ColumnInfo(name = "Dateandtime") var Dateandtime: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}

@Entity(tableName = "Expenses")
data class ExpensesTable(
    @ColumnInfo(name = "Description") var Description: String,
    @ColumnInfo(name = "Amount") var Amount: Int,
    @ColumnInfo(name = "Dateandtime") var Dateandtime: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}