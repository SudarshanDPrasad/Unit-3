package com.application.tastyapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.application.tastyapp.R
import com.application.tastyapp.adaptor.FavAdaptor
import com.application.tastyapp.response.model.data.favdata.FavDao
import com.application.tastyapp.response.model.data.favdata.FavRoomDataBase
import com.application.tastyapp.response.model.data.favdata.FavTable
import com.application.tastyapp.response.model.frontScreen.ItemX
import com.application.tastyapp.viewModel.TastyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favourite.*

@AndroidEntryPoint
class FavouriteFragment : Fragment(R.layout.fragment_favourite) {
    var list = mutableListOf<FavTable>()
    lateinit var favDao: FavDao
    lateinit var favRoomDataBase: FavRoomDataBase
    lateinit var tastyViewModel: TastyViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tastyViewModel = ViewModelProviders.of(this).get(TastyViewModel::class.java)
        favRoomDataBase = FavRoomDataBase.getDataBaseObjectFav(context!!.applicationContext)
        favDao = favRoomDataBase.getDaoFav()

        tastyViewModel.dataFromDb().observe(this, {
            list.addAll(it)
            val adaptor = FavAdaptor(list)
            val layoutManager = GridLayoutManager(context, 2)
            fav_recyclerView.adapter = adaptor
            fav_recyclerView.layoutManager = layoutManager
        })
    }
}