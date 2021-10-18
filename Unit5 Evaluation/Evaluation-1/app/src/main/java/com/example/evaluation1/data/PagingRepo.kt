package com.example.evaluation1.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.evaluation1.api.ApiClient
import com.example.evaluation1.api.Network
import com.example.evaluation1.localdatabase.PersonDao
import com.example.evaluation1.response.ResponseModel
import com.example.evaluation1.response.ResponseModelItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PagingRepo(var personDao: PersonDao) {


    private var apiClient: ApiClient = Network.getApiService()

    fun getResponse() {

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiClient.getApiresponse()
            saveToDB(response)
        }
    }

    fun saveToDB(response: ResponseModel?) {
        val listofPerson = ArrayList<PersonTable>()
        response?.forEach {
            if ((it?.birthday != null && it?.deathday != null)) {
                val person = PersonTable(it.deathday, it.birthday)
                listofPerson.add(person)
            } else {
                "null"
            }
        }
        personDao.deleteAll()
        personDao.addTasks(listofPerson)
    }


    fun getPageslIst() =
        Pager(
            config = PagingConfig(
                pageSize = 20,

                ),
            pagingSourceFactory = { PagingSource() }
        ).liveData
}