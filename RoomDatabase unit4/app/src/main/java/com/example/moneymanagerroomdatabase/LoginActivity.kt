package com.example.moneymanagerroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.moneymanagerroomdatabase.models.local.TaskDAO
import com.example.moneymanagerroomdatabase.models.local.TaskRoomDataBase
import com.example.moneymanagerroomdatabase.viewmodels.TaskViewModel
import com.example.roomdatabase.models.remote.Status
import com.example.moneymanagerroomdatabase.remote.requests.LoginRequestModel
import com.example.moneymanagerroomdatabase.repository.TaskRepo
import com.example.roomdatabase.viewmodels.TaskViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.longToast

class LoginActivity : AppCompatActivity() {
    lateinit var roomDataBase: TaskRoomDataBase
    lateinit var taskDAO: TaskDAO
    lateinit var viewmodel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        roomDataBase = TaskRoomDataBase.getDataBaseObject(this)
        taskDAO = roomDataBase.getTaskDAO()

        val repo = TaskRepo(taskDAO)
        val viewModelFactory = TaskViewModelFactory(repo)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(TaskViewModel::class.java)


        btnLogin.setOnClickListener {
            val loginRequestModel = LoginRequestModel(
                userName = EtEmail.text.toString(),
                password = EtPassword.text.toString())


            viewmodel.userLogin(loginRequestModel).observe(this, Observer {
                val response = it

                when (response.status) {

                    Status.SUCCESS -> {

                        val intent = Intent(this, MainActivity::class.java)
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

        btntosignup.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }

}