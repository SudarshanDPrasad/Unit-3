package com.application.communicationbetweenactivity.interfaceActivity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.application.communicationbetweenactivity.R
import kotlinx.android.synthetic.main.fragment_inter_face_a.*
import kotlinx.android.synthetic.main.fragment_inter_face_b.*

class InterFaceFragmentB : Fragment(R.layout.fragment_inter_face_b), FragmentInterFaceA {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnIncreaseInterfaceFragmentB.setOnClickListener {
            val activity : InterfaceAct = getActivity() as InterfaceAct
            activity.setResultA("Button1")
        }
    }

    override fun setResultA(s: String) {
        TxtCountFragmentB.setText("$s from Fragment A")
    }

}