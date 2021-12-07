package com.application.contactreadapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ContactViewModel(application: Application) : AndroidViewModel(application) {
   fun save(contactTable: MutableList<ContactTable>) {
       CoroutineScope(Dispatchers.IO).launch {
           db.deleteall()
           db.insertdata(contactTable)
       }
    }

    val db: ContactDao = ContactDataBase.getDataBaseObject(application).contactdao()

    val Contactlist = Pager(
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
        ),
    ) {
        db.getPages()
    }.flow

    fun updatecontact(contactTable: ContactTable){
        CoroutineScope(Dispatchers.IO).launch {
            db.updateContact(contactTable)
        }
    }

}