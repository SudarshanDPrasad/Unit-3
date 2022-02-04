package com.application.indianews.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import com.application.indianews.R
import com.application.indianews.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        fragmentHomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
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

        fragmentHomeBinding.cardNational.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToNationalFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        fragmentHomeBinding.etQuerySearch.setOnClickListener {
            val query = fragmentHomeBinding.etQuerySearch.text.toString()
            val action = HomeFragmentDirections.actionHomeFragment2ToQueryFragment(query)
            Navigation.findNavController(requireView()).navigate(action)
        }

    }
}