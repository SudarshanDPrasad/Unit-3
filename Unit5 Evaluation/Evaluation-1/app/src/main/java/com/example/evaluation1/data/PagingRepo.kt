package com.example.evaluation1.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.evaluation1.localdatabase.PersonDao
import com.example.evaluation1.response.ResponseModelItem

class  PagingRepo(var personDao: PersonDao) {


    fun getResponse(response: ResponseModelItem){
        val listofPerson = ArrayList<PersonTable>()
        response.let{

            val person = PersonTable(it.country)
        }
    }
    fun getPageslIst() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
            ),
            pagingSourceFactory = { PagingSource() }
        ).liveData
}