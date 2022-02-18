package com.application.communicationbetweenactivity.viewModelActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.application.communicationbetweenactivity.R
import kotlinx.android.synthetic.main.fragment_view_model_b.*

class ViewModelFragmentB : Fragment(R.layout.fragment_view_model_b) {
    private lateinit var viewModelFragment: ViewModelFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFragment =
            ViewModelProviders.of(requireActivity()).get(ViewModelFragment::class.java)

        viewModelFragment.getSelectedItem().observe(requireActivity(), {
            TxtCOunt.setText(it.toString())
        })
    }
}