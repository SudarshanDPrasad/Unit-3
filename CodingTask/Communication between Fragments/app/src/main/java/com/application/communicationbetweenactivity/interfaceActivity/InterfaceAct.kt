package com.application.communicationbetweenactivity.interfaceActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.application.communicationbetweenactivity.R

class InterfaceAct : AppCompatActivity(), FragmentInterFaceA , FragmentInterFaceB {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface)

        val fragmentA: InterFaceFragmentA = InterFaceFragmentA()
        supportFragmentManager.beginTransaction().add(R.id.fragA, fragmentA, "Tag_A").commit()
        val fragmentB: InterFaceFragmentB = InterFaceFragmentB()
        supportFragmentManager.beginTransaction().add(R.id.fragB, fragmentB, "Tag_B").commit()
    }

    override fun setResultA(s: String) {
        val fragment: Fragment = supportFragmentManager.findFragmentByTag("Tag_B")!!
        val fragmentB: InterFaceFragmentB = fragment as InterFaceFragmentB
        fragmentB.setResultA(s)
    }

    override fun setResultB(s: String) {
        val fragment: Fragment = supportFragmentManager.findFragmentByTag("Tag_A")!!
        val fragmentA: InterFaceFragmentA = fragment as InterFaceFragmentA
        fragmentA.setResultB(s)
    }
}