package com.application.communicationbetweenactivity.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.communicationbetweenactivity.R
import com.application.communicationbetweenactivity.interfaceActivity.InterfaceAct
import com.application.communicationbetweenactivity.viewModelActivity.ViewModelAct

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewModelActivity.setOnClickListener {
            val intent = Intent(this,ViewModelAct::class.java)
            startActivity(intent)
        }

        InterfaceActivity.setOnClickListener {
            val intent = Intent(this,InterfaceAct::class.java)
            startActivity(intent)
        }
    }
}