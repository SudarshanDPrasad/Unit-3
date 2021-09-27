package com.example.moneymanagerroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.moneymanagerroomdatabase.models.local.TaskDAO
import com.example.moneymanagerroomdatabase.models.local.TaskRoomDataBase
import com.example.moneymanagerroomdatabase.repository.TaskRepo
import com.example.moneymanagerroomdatabase.responses.SignupRequestModel
import com.example.moneymanagerroomdatabase.viewmodels.TaskViewModel
import com.example.roomdatabase.models.remote.Status
import com.example.roomdatabase.viewmodels.TaskViewModelFactory
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.longToast

class SignupActivity : AppCompatActivity() {

    lateinit var roomDataBase: TaskRoomDataBase
    lateinit var taskDAO: TaskDAO
    lateinit var viewmodel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        roomDataBase = TaskRoomDataBase.getDataBaseObject(this)
        taskDAO = roomDataBase.getTaskDAO()

        val repo = TaskRepo(taskDAO)
        val viewModelFactory = TaskViewModelFactory(repo)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(TaskViewModel::class.java)

        btnsignup.setOnClickListener {
            val signupRequestModel = SignupRequestModel(
                name = EtName.text.toString(),
                email = EtEmail.text.toString(),
                password = EtPassword.text.toString(),
                age = EtAge.text.toString().toInt()
            )

            viewmodel.signup(signupRequestModel).observe(this, Observer {
                val response = it

                when (response.status) {

                    Status.SUCCESS -> {

                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }

                    Status.ERROR -> {

                        val error = response.message!!
                        longToast("error = $error")

                    }

                    Status.LOADING -> {

                    }
                }

            })

        }

    }
}