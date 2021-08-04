package com.example.we_part;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.we_part.Fragments.StudentPerformanceDetailsFragment;
import com.example.we_part.Fragments.StudentPersonalDetailsFragment;
import com.example.we_part.Interface.CommunicationListener;

public class MainActivity extends AppCompatActivity implements CommunicationListener {

    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchstudentpersonaldeatils();

    }

    private void launchstudentpersonaldeatils() {
        fragmentManager = getSupportFragmentManager();
        StudentPersonalDetailsFragment studentPersonalDetailsFragment = new StudentPersonalDetailsFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, studentPersonalDetailsFragment, "Personal").commit();

    }

    @Override
    public void launchperformancefragment(Bundle bundle) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment studentPerformanceDetailsFragment = new StudentPerformanceDetailsFragment();
        studentPerformanceDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container,studentPerformanceDetailsFragment,"performace").addToBackStack("performace").commit();

    }
}