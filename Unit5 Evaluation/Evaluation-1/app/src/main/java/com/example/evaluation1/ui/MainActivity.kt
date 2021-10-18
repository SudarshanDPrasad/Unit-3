package com.example.evaluation1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evaluation1.R
import com.example.evaluation1.adaptor.PersonAdaptor
import com.example.evaluation1.data.PagingRepo
import com.example.evaluation1.data.PagingViewModel
import com.example.evaluation1.databinding.ActivityMainBinding
import com.example.evaluation1.localdatabase.PersonDao
import com.example.evaluation1.localdatabase.PersonDatabase
import com.example.evaluation1.localdatabase.PersonViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var pagingViewModel: PagingViewModel
    private lateinit var personAdaptor: PersonAdaptor
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var personDatabase: PersonDatabase
    lateinit var dao: PersonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        personDatabase = PersonDatabase.getDataBaseObject(this)
        dao = personDatabase.getTaskDAO()
        val repo = PagingRepo(dao)
        val viewmodelfactory = PersonViewModelFactory(repo)

        pagingViewModel = ViewModelProvider(this,viewmodelfactory).get(PagingViewModel::class.java)
        setAdaptor()

        pagingViewModel.getPages().observe(this,{
            it?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    personAdaptor.submitData(it)
                }
            }
        })

        pagingViewModel.getApi()
    }

    private fun setAdaptor() {
        personAdaptor = PersonAdaptor()
        val linearLayoutManager = LinearLayoutManager(this)
        mainBinding.recyclerview.apply {
            adapter = personAdaptor
            layoutManager = linearLayoutManager
        }
    }
}