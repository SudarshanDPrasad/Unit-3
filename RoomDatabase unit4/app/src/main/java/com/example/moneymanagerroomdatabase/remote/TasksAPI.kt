package com.example.roomdatabase.models.remote

import com.example.moneymanagerroomdatabase.remote.requests.LoginRequestModel
import com.example.moneymanagerroomdatabase.responses.SignupRequestModel
import com.example.moneymanagerroomdatabase.responses.SignupResponseModel
import com.example.roomdatabase.models.responses.CreateTaskRequestModel
import com.example.roomdatabase.models.responses.CreateTaskResponseModel
import com.example.roomdatabase.models.responses.GetTasksResponseModel
import com.example.roomdatabase.models.responses.LoginResponse
import retrofit2.http.*


interface TasksAPI {

    //@Headers("Accept: application/json")
    @POST("users/login")
    suspend fun login(
        @Body loginRequest: LoginRequestModel
    ): LoginResponse


    @GET(" tasks")
    suspend fun getTasksFromAPI(
        @Header("Authorization") token: String
    ) : GetTasksResponseModel


    @POST("tasks")
    suspend fun createTask(
        @Header("Authorization") token: String,
        @Body createTaskRequestModel: CreateTaskRequestModel
    ): CreateTaskResponseModel

    @POST("users/")
    suspend fun signup(
        @Body signupRequestModel: SignupRequestModel
    ): SignupResponseModel


    /*@POST("/v2/courses/new")
    suspend fun signUp(
        @Header("Authorization") authToken: String?,
        @Body createNewCourseRequest: CreateNewCourseRequest
    ): CreateNewCourseResponse

    @GET("app/android/version")
    suspend fun getAllTasks(
        @Header("Content-Type") contentType: String
    ): ForceUpdateAppResponseModel*/


    /*@POST("v2/data/{code}/register")
    suspend fun getPostPaymentDetails(
        @Header("Authorization") authToken: String?,
        @Path("code") code: String,
        @Body postPaymentRequestModel: PostPaymentRequestModel
    ): PostPaymentRequestModel*/


    /*@GET("/v2/videos/generate-live-token")
    suspend fun getLiveToken(
        @Header("Authorization") token: String,
        @Header("Content-Type") contentType: String,
        @Query("l_id") lessonId: String,
        @Query("user_id") userId: String,
        @Query("role") role: String
    ): GetLiveTokenResponseModel*/

}