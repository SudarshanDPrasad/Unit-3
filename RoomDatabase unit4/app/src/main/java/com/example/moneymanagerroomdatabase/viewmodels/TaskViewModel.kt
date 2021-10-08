package com.example.moneymanagerroomdatabase.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moneymanagerroomdatabase.models.local.TaskIncome
import com.example.moneymanagerroomdatabase.remote.requests.LoginRequestModel
import com.example.moneymanagerroomdatabase.responses.SignupRequestModel
import com.example.moneymanagerroomdatabase.responses.SignupResponseModel
import com.example.roomdatabase.models.responses.LoginResponse
import com.example.moneymanagerroomdatabase.repository.TaskRepo
import com.example.roomdatabase.models.remote.Resource
import com.example.roomdatabase.models.responses.CreateTaskRequestModel
import kotlinx.coroutines.Dispatchers

class TaskViewModel(private val repo: TaskRepo) : ViewModel() {

    //login
    fun userLogin(loginRequestModel: LoginRequestModel): LiveData<Resource<LoginResponse>> {

        val liveData = liveData(Dispatchers.IO) {
            val result: Resource<LoginResponse> = repo.login(loginRequestModel)
            emit(result)
        }
        return liveData
    }

    //signup
    fun signup(signupRequestModel: SignupRequestModel):LiveData<Resource<SignupResponseModel>>{
        return liveData(Dispatchers.IO) {
            val result : Resource<SignupResponseModel> = repo.signup(signupRequestModel)
            emit(result)
        }
    }

    //Api
    fun createNewTask(createTaskRequestModel: CreateTaskRequestModel){
        repo.createTask(createTaskRequestModel)
    }

    fun addTask(taskIncome: TaskIncome) {
        repo.addTaskToRoom(taskIncome)
    }

}