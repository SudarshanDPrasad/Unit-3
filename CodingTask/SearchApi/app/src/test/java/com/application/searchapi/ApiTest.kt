package com.application.searchapi

import com.application.searchapi.apicalls.ApiCity
import com.application.searchapi.data.*
import com.application.searchapi.response.ResponseDTO
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.lang.Exception
import java.net.SocketException

class ApiTest {


    @Mock
    lateinit var cityRepo: CityRepo

    @Mock
    lateinit var apiCity: ApiCity

    @Mock
    lateinit var responseHandler: ResponseHandler
    lateinit var cityViewModel: CityViewModel

    @Mock
    lateinit var responseDTO: ResponseDTO


    lateinit var success : Resource<ResponseDTO>
    lateinit var failure : Resource<ResponseDTO>

    @Mock
    lateinit var socketException: SocketException
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        cityViewModel = CityViewModel()

        CoroutineScope(Dispatchers.IO).launch {
            data()
        }
    }



    @Test
    fun getting_matching_addresses_success() {
        cityViewModel.getData("mumbai")
        assertEquals(success.status, Status.SUCCESS)

    }

    @Test
    fun getting_matching_addresses_failed() {
        cityViewModel.getData("kerala")
        assertEquals(failure.status, Status.ERROR)
    }


    suspend fun data(){
        failure = responseHandler.handleException(socketException)
        success = responseHandler.handleSuccess(responseDTO)

        `when`<ResponseDTO>(apiCity.getCityName(
            "airtel",""))
            .thenReturn(responseDTO)

        `when`<Resource<ResponseDTO>>(cityRepo.getAllCities(
            "mumbai"))
            .thenReturn(failure)

        `when`<Resource<ResponseDTO>>(cityRepo.getAllCities(
            "mumbai"))
            .thenReturn(success)
    }

}