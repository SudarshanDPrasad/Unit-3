package com.application.indianews.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.application.indianews.R
import com.application.indianews.adaptor.NewsAdaptor
import com.application.indianews.data.NewsViewModel
import com.application.indianews.data.Status
import com.application.indianews.reponse.Data
import kotlinx.android.synthetic.main.fragment_business.*
import kotlinx.android.synthetic.main.fragment_entertainment.*


class EntertainmentFragment : Fragment(R.layout.fragment_entertainment) {
    private var list = emptyList<Data>()
    private lateinit var newsViewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        loadData()
    }

    private fun loadData() {
        newsViewModel.EntertainmentData().observe(viewLifecycleOwner, {
            when (it.status) {
                Status.ERROR ->{
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }

                Status.SUCCESS ->{
                    list = it.data?.data!!
                    val adaptor = NewsAdaptor(list)
                    fragment_entertainment_Viewpager.adapter = adaptor
                }
            }
        })
    }
}