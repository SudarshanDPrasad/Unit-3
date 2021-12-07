package com.application.indianews.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import com.application.indianews.R
import com.application.indianews.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {


    lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentHomeBinding.cardSports.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToSportsFragment2()
            Navigation.findNavController(requireView()).navigate(action)
        }

        fragmentHomeBinding.cardAutomobile.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToAutoMobileFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        fragmentHomeBinding.cardBusiness.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToBusinessFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        fragmentHomeBinding.cardEntertainment.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToEntertainmentFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }


        fragmentHomeBinding.cardTechnology.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToTechnologyFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
    }
}