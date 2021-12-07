package com.application.contactreadapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), onCLick {

    lateinit var contactViewModel: ContactViewModel
    val contactlist = mutableListOf<ContactTable>()
    lateinit var paginAdaptor: PaginAdaptor


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)


        Contacts_RecyclerView.layoutManager = LinearLayoutManager(this)
        paginAdaptor = PaginAdaptor(this)
        val contacts = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null)
        while (contacts!!.moveToNext()) {

            val name =
                contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val number =
                contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            val ContactName = name
            val ContactNumber = number



            contactlist.add(ContactTable(ContactName, ContactNumber, 0))
        }
        contacts.close()

        loadContact()

        Contacts_RecyclerView.adapter = paginAdaptor

    }

    private fun loadContact() {
        contactViewModel.save(contactlist)
        lifecycleScope.launch {
            contactViewModel.Contactlist.collect {
                paginAdaptor.submitData(it)
            }
        }

    }

    override fun OnCardclick(contactTable: ContactTable?) {
        val contactcount = contactTable?.contactcount

        if (contactcount != null) {
            contactTable.contactcount = contactcount + 1
        }
        contactViewModel.updatecontact(contactTable!!)

    }
}