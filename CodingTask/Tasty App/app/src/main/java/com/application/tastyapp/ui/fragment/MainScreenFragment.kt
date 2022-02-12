package com.application.tastyapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tastyapp.R
import com.application.tastyapp.adaptor.RecyclerViewAdapter
import com.application.tastyapp.databinding.FragmentMainScreenBinding
import com.application.tastyapp.response.model.frontScreen.ItemX
import com.application.tastyapp.response.model.frontScreen.ResultModel
import com.application.tastyapp.response.module.Status
import com.application.tastyapp.response.onClick.onClickListener
import com.application.tastyapp.ui.activity.login.DetailActivity
import com.application.tastyapp.viewModel.TastyViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainScreenFragment : Fragment(), onClickListener {


    lateinit var mainScreenBinding: FragmentMainScreenBinding
    lateinit var tastyViewModel: TastyViewModel
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mainScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)
        return mainScreenBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tastyViewModel = ViewModelProviders.of(this).get(TastyViewModel::class.java)
        loadData()
    }

    private fun loadData() {
        tastyViewModel.getData().observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    val list = it.data as ArrayList<ResultModel>
                    setAdapter(list)
                }
                Status.ERROR -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setAdapter(list: ArrayList<ResultModel>) {
        adapter = RecyclerViewAdapter(list, this)
        mainScreenBinding.mainRecyclerView.adapter = adapter
        mainScreenBinding.mainRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onClickOfView(itemX: ItemX) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("data", itemX)
        startActivity(intent)
    }
}