package com.application.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.firebase.databinding.ActivityMainBinding
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var list: ArrayList<ResponseModel>
    private lateinit var database: DatabaseReference
    var i = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        activityMainBinding.buttonToAdd.setOnClickListener {
            val intent: Intent = Intent(this, AnimalAddActivity::class.java)
            startActivity(intent)
        }


        list = arrayListOf<ResponseModel>()
        activityMainBinding.mainrecyclerview.layoutManager = LinearLayoutManager(this)
        activityMainBinding.horizontalrecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        getUserData()
    }

    private fun getUserData() {
        database = FirebaseDatabase.getInstance().getReference("ResponseModel")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {


                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(ResponseModel::class.java)
                        list.add(user!!)

                    }

                    var adaptor = AnimalAdaptor(this@MainActivity, list)
                    activityMainBinding.mainrecyclerview.adapter = adaptor
                    adaptor.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {

                Log.d("sudrshan", "Error")
            }

        })

    }
}