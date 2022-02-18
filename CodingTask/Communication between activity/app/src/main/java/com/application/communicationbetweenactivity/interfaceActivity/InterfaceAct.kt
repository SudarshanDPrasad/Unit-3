package com.application.communicationbetweenactivity.interfaceActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.application.communicationbetweenactivity.R

class InterfaceAct : AppCompatActivity(), FragmentInterFace {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface)

        val fragmentA: InterFaceFragmentA = InterFaceFragmentA()
        supportFragmentManager.beginTransaction().add(R.id.fragA, fragmentA).commit()
        val fragmentB: InterFaceFragmentB = InterFaceFragmentB()
        supportFragmentManager.beginTransaction().add(R.id.fragB, fragmentB, "Tag_B").commit()
    }

    override fun setResult(s: String) {
        val fragment: Fragment = supportFragmentManager.findFragmentByTag("Tag_B")!!
        val fragmentB: InterFaceFragmentB = fragment as InterFaceFragmentB
        fragmentB.setResult(s)
    }
}