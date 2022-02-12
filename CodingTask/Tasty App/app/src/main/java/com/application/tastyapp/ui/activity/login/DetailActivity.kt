package com.application.tastyapp.ui.activity.login

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tastyapp.R
import com.application.tastyapp.adaptor.InstructionAdapter
import com.application.tastyapp.databinding.ActivityDetailBinding
import com.application.tastyapp.databinding.ActivityDetailBindingImpl
import com.application.tastyapp.response.model.data.favdata.FavDao
import com.application.tastyapp.response.model.data.favdata.FavRoomDataBase
import com.application.tastyapp.response.model.data.favdata.FavTable
import com.application.tastyapp.response.model.data.logindata.LoginDao
import com.application.tastyapp.response.model.data.logindata.LoginRoomDataBase
import com.application.tastyapp.response.model.frontScreen.InstructionX
import com.application.tastyapp.response.model.frontScreen.ItemX
import com.application.tastyapp.viewModel.TastyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail.*

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    lateinit var detailBindingImpl: ActivityDetailBinding
    lateinit var favDao: FavDao
    lateinit var favRoomDataBase: FavRoomDataBase
    lateinit var tastyViewModel: TastyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        detailBindingImpl = ActivityDetailBindingImpl.inflate(layoutInflater)
        setContentView(detailBindingImpl.root)

        tastyViewModel = ViewModelProviders.of(this).get(TastyViewModel::class.java)
        favRoomDataBase = FavRoomDataBase.getDataBaseObjectFav(this)
        favDao = favRoomDataBase.getDaoFav()

        val data = intent.getSerializableExtra("data") as ItemX
        detailBindingImpl.data = data
        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_share.setOnClickListener {

        }

        btn_favourite.setOnClickListener {
            btn_favourite.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
            tastyViewModel.addDataFav(FavTable(data.name,
                data.thumbnailUrl,
                data.videoUrl))
        }

        setData(data)
    }

    private fun setData(data: ItemX) {
        val uri = Uri.parse(data.videoUrl)
        videoView2.setVideoURI(uri)
        videoView2.start()
        val instructionList = data.instructions as ArrayList<InstructionX>
        tv_LikeTotal.text =
            ("${(data.userRatings.score * 100).toInt().toString()} % of people liked this recipe ")
        setRecyclerview(instructionList)
    }


    fun setRecyclerview(instructionList: ArrayList<InstructionX>) {
        details_recyclerView.apply {
            adapter = InstructionAdapter(instructionList)
            layoutManager =
                LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
        }

    }

}