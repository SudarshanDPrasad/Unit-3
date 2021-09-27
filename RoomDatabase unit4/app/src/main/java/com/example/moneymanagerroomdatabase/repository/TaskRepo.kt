package com.example.moneymanagerroomdatabase.repository

import com.example.moneymanagerroomdatabase.models.local.TaskDAO
import com.example.moneymanagerroomdatabase.models.local.TaskExpenses
import com.example.moneymanagerroomdatabase.models.local.TaskIncome
import com.example.moneymanagerroomdatabase.remote.Network
import com.example.roomdatabase.models.remote.TasksAPI
import com.example.moneymanagerroomdatabase.remote.requests.LoginRequestModel
import com.example.moneymanagerroomdatabase.responses.SignupRequestModel
import com.example.moneymanagerroomdatabase.responses.SignupResponseModel
import com.example.roomdatabase.models.responses.LoginResponse
import com.example.roomdatabase.models.remote.Resource
import com.example.roomdatabase.models.remote.ResponseHandler
import com.example.roomdatabase.models.responses.CreateTaskRequestModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class TaskRepo(val taskDAO: TaskDAO) {

    private val api: TasksAPI = Network.getRetrofit().create(TasksAPI::class.java)
    private val responseHandler = ResponseHandler()
    private val token =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MTRkZjQ5ZWYwNDg1NDBiNWMxNDk0OTAiLCJpYXQiOjE2MzI0OTg4NDZ9.XAgdJTr2GsqAZrhHd9ZGvUE_rCmmWOh7tsPEzROCPds"

    //login
    suspend fun login(loginRequestModel: LoginRequestModel): Resource<LoginResponse> {
        return try {
            val response = api.login(loginRequestModel)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun signup(signupRequestModel: SignupRequestModel) : Resource<SignupResponseModel>{
        return try {
            val response = api.signup(signupRequestModel)
            responseHandler.handleSuccess(response)
        }catch (e:Exception){
            responseHandler.handleException(e)
        }
    }

//    //Create task
    fun createTask(createTaskRequestModel: CreateTaskRequestModel){
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.createTask(token,createTaskRequestModel)
            val newTask = TaskIncome(response.title,response.status.toDouble(),response.description)
            taskDAO.addTaskincome(newTask)
        }
    }

//    fun addTaskToRoom(taskIncome: TaskIncome) {
//        CoroutineScope(Dispatchers.IO).launch {
//            taskDAO.addTaskincome(taskIncome)
//        }
//    }
}