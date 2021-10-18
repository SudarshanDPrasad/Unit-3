package com.example.evaluation1.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "PersonDetails")
class PersonTable(
    @ColumnInfo(name = "DOB") var DOB: String,
    @ColumnInfo(name = "DOD") var DOD: String,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}