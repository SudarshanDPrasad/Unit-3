package com.application.newsapi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.newsapi.R
import com.application.newsapi.databinding.ActivityOnClickBinding
import com.bumptech.glide.Glide

class OnClickActivity : AppCompatActivity() {

    private lateinit var onClickBinding: ActivityOnClickBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_on_click)
        onClickBinding = ActivityOnClickBinding.inflate(layoutInflater)
        setContentView(onClickBinding.root)

        val image = intent.getStringExtra("URLImage")
        Glide.with(onClickBinding.IvOnclickImage).load(image).into(onClickBinding.IvOnclickImage)
        val publishDate = intent.getStringExtra("publishDate")
        onClickBinding.tvInsidePublishData.setText(publishDate)
        val description = intent.getStringExtra("description")
        onClickBinding.TVInsideDescription.setText(description)
        val tittle = intent.getStringExtra("tittle")
        onClickBinding.TVInsideTittle.setText(tittle)

        onClickBinding.btnback.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}