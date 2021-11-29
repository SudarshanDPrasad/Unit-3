package com.application.scenariocinema.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.scenariocinema.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val lang = intent.getStringExtra("Language");
        tv_Original_Language.setText(lang)
        val backdrop = intent.getStringExtra("image")
        val Geners = intent.getStringExtra("Generes")
        tv_Original_Geners.setText(Geners)
        val Date = intent.getStringExtra("realeaseDate")
        tv_ReleaseDate.setText(Date)
        Glide.with(Iv_Detial_Image).load(backdrop).into(Iv_Detial_Image)
    }
}