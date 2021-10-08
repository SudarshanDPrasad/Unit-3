package com.example.databindingapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingapi.databinding.ActivityMainBinding
import com.example.databindingapi.response.IndianToon
import com.example.databindingapi.response.Response_DTO
import com.example.recyclerdatabinding.Adaptor.MoviesAdaptor
import com.example.recyclerdatabinding.response.ApiCLinet
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var moviemodel: List<IndianToon>
    lateinit var popularMoviesAdapter: MoviesAdaptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


      activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply {

            apicalling()
        }
    }

    private fun apicalling() {
        var apiCLinet = Network.getInstance().create(ApiCLinet::class.java)
        apiCLinet.getAPIResponse().enqueue(
            object : retrofit2.Callback<Response_DTO> {
                override fun onResponse(
                    call: Call<Response_DTO>,
                    response: Response<Response_DTO>,
                ) {
                    response.body()?.run {
                        moviemodel = response.body()!!.indianToons
                        setrecycler()
                    }
                }

                override fun onFailure(call: Call<Response_DTO>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

    private fun setrecycler() {
        popularMoviesAdapter = MoviesAdaptor(moviemodel)
        activityMainBinding.recyclerviewrc.layoutManager = LinearLayoutManager(this@MainActivity)
        activityMainBinding.recyclerviewrc.adapter = popularMoviesAdapter
    }
}