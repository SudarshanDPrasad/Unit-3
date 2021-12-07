package com.application.codejudge_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAdd.setOnClickListener {
            if (txtNumber1 != null && txtNumber2 != null) {
                var sum: Int =
                    txtNumber1.text.toString().toInt() + txtNumber2.text.toString().toInt()
                txtResult.setText(sum.toString())
            } else {

            }
        }
    }
}