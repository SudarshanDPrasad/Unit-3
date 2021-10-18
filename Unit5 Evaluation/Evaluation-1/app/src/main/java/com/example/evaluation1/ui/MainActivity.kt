package com.example.evaluation1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evaluation1.R
import com.example.evaluation1.adaptor.PersonAdaptor
import com.example.evaluation1.data.PagingViewModel
import com.example.evaluation1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var pagingViewModel: PagingViewModel
    private lateinit var personAdaptor: PersonAdaptor
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        pagingViewModel = ViewModelProvider(this).get(PagingViewModel::class.java)
        setAdaptor()

        pagingViewModel.getPages().observe(this,{
            it?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    personAdaptor.submitData(it)
                }
            }
        })
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