package com.application.communicationbetweenactivity.viewModelActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.application.communicationbetweenactivity.R
import kotlinx.android.synthetic.main.fragment_view_model_a.*
import kotlinx.android.synthetic.main.fragment_view_model_b.*

class ViewModelFragmentA : Fragment(R.layout.fragment_view_model_a) {
    private var count: Int = 0
    private lateinit var viewModelFragment: ViewModelFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModelFragment =
            ViewModelProviders.of(requireActivity()).get(ViewModelFragment::class.java)

        btnincreaseA.setOnClickListener {
            count++
            viewModelFragment.setDataB(count)

        }

        viewModelFragment.getSelectedItemA().observe(requireActivity(), {
            TxtCountViewModelA.setText("${it.toString()} from fragment B ")
        })
    }

}