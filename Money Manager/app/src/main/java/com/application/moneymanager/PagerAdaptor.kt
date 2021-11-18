package com.application.moneymanager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.application.moneymanager.fragments.Balance
import com.application.moneymanager.fragments.Expenses
import com.application.moneymanager.fragments.Income


class PagerAdaptor(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }


    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return Income()
            1 -> return Expenses()

        }
        return null!!
    }
}