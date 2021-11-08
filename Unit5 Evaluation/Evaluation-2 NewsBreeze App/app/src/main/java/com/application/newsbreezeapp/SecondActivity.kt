package com.application.newsbreezeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       val name = intent.getStringExtra("author name")
       val title = intent.getStringExtra("title")
       val date = intent.getStringExtra("date")
       val description = intent.getStringExtra("description")
       val image = intent.getStringExtra("image")
        authorname.setText(name)
        authortitle.setText(title)
        authordate.setText(date)
        authordescription.setText(description)

        Glide.with(authorimage).load(image).into(authorimage)

    }
}

/*
intent.putExtra("author name",article.author)
        intent.putExtra("image",article.urlToImage)
        intent.putExtra("title",article.title)
        intent.putExtra("date",article.publishedAt)
        intent.putExtra("description",article.description)
 */