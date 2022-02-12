package com.application.tastyapp.ui.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.application.tastyapp.R
import com.application.tastyapp.ui.fragment.FavouriteFragment
import com.application.tastyapp.ui.fragment.MainScreenFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Recipe -> {
                    moveToFragment(MainScreenFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.fav -> {
                    moveToFragment(FavouriteFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener)

        moveToFragment(MainScreenFragment())
    }

    private fun moveToFragment(fragment: Fragment) {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.nav_host_fragment, fragment)
        fragmentTrans.commit()
    }
}