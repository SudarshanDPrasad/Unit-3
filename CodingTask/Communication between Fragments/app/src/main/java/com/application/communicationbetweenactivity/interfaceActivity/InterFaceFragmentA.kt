package com.application.communicationbetweenactivity.interfaceActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.communicationbetweenactivity.R
import kotlinx.android.synthetic.main.fragment_inter_face_a.*

class InterFaceFragmentA : Fragment(R.layout.fragment_inter_face_a) , FragmentInterFaceB {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnIncreaseInterfaceFragmentA.setOnClickListener {
            val activity : InterfaceAct = getActivity() as InterfaceAct
            activity.setResultA("Button1")
        }

    }

    override fun setResultB(s: String) {
        TxtCountFragmentA.setText("$s from Fragment B")
    }
}