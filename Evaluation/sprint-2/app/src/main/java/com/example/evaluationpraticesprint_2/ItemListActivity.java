package com.example.evaluationpraticesprint_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.evaluationpraticesprint_2.Fragment.ItemListFragment;

public class ItemListActivity extends AppCompatActivity {

    private FrameLayout flcontanier;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        fragmentManager = getSupportFragmentManager();
        flcontanier = findViewById(R.id.flcontainer);
        launchlistfragment();
    }

    public void launchlistfragment(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ItemListFragment itemListFragment = new ItemListFragment();
        fragmentTransaction.add(R.id.flcontainer,itemListFragment,"itemListFragment").addToBackStack("itemListFragment").commit();
    }
}