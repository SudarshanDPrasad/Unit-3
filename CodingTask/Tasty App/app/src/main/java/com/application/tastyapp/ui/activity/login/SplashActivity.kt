package com.application.tastyapp.ui.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.application.tastyapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val backgroundImg : ImageView = findViewById(R.id.iv_splash_logo)
        val sideAnimation = AnimationUtils.loadAnimation(this,R.anim.slide)
        backgroundImg.startAnimation(sideAnimation)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
        },3000)
    }
}