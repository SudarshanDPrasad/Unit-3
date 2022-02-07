package com.application.tastyapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.application.tastyapp.R
import com.application.tastyapp.response.model.frontScreen.ItemX
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment(R.layout.fragment_detail) {
    val args: DetailFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val query = args.reciepeDetial
        loadData(query)
    }

    private fun loadData(query: ItemX) {
        tv_Checking.text = query.name
    }
}