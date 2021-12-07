package com.application.contactreadapp

import androidx.paging.PagingSource
import androidx.room.*

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertdata(contactTable: MutableList<ContactTable>)

    @Query("select * from contacts order by Contact_count DESC")
    fun getPages(): PagingSource<Int, ContactTable>

    @Update
    suspend fun updateContact(contactTable: ContactTable)

    @Query("delete from contacts")
    fun deleteall()
}