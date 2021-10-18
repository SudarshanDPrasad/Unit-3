package com.example.evaluation1.localdatabase

import androidx.room.*
import com.example.evaluation1.data.PersonTable

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(personTable: ArrayList<PersonTable>)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateData(personTable: PersonTable)

    @Insert(onConflict = OnConflictStrategy.REPLACE) //Replace the item
    fun addTasks(task: ArrayList<PersonTable>)

    @Query("delete from persondetails")
    fun deleteAll()
}