package com.application.tastyapp.ui.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.application.tastyapp.R
import com.application.tastyapp.response.model.data.logindata.LoginDao
import com.application.tastyapp.response.model.data.logindata.LoginRoomDataBase
import com.application.tastyapp.response.model.data.logindata.LoginTable
import com.application.tastyapp.viewModel.TastyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    lateinit var loginDao: LoginDao
    lateinit var loginRoomDataBase: LoginRoomDataBase
    lateinit var tastyViewModel: TastyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tastyViewModel = ViewModelProviders.of(this).get(TastyViewModel::class.java)
        loginRoomDataBase = LoginRoomDataBase.getDataBaseObject(this)
        loginDao = loginRoomDataBase.getDao()

        btn_Login.setOnClickListener {
            val save = LoginTable(et_UserName.toString(), et_Password.toString())
            tastyViewModel.addData(save)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}