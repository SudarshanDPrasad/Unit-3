package com.example.viewpagerwithcircleindicator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {


    public PagerAdapter(@NonNull  FragmentManager fragmentManager, @NonNull  Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);


    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return FragmentA.newInstance("Enjoy the plane Service","Enjoying the flight in your Acamedy is the best way to fell the weather ");

            case 1: return FragmentB.newInstance("Baggage Counter ","Before Flying have a luggage check for the Safety purpose   ");

            case 2: return FragmentC.newInstance("Waiting Lounge ","Waiting in the Lounge before Boarding so you relax ");

            case 3: return FragmentD.newInstance("Family travelling","Have a nice time with your family have a safe journey ");
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
