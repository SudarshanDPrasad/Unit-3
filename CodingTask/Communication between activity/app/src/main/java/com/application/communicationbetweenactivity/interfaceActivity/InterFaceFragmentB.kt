package com.application.communicationbetweenactivity.interfaceActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.communicationbetweenactivity.R
import kotlinx.android.synthetic.main.fragment_inter_face_b.*

class InterFaceFragmentB : Fragment(R.layout.fragment_inter_face_b), FragmentInterFace {


    override fun setResult(s: String) {
        TxtCountFragmentB.setText(s)
    }

}