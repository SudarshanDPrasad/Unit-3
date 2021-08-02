package com.example.dynamicfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mlllayout;
    FrameLayout flContainer;
    FragmentManager fragmentManager;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
    }

    private void initviews() {
        mlllayout = findViewById(R.id.LinearLayout);
        flContainer = findViewById(R.id.flcontainer);
        tv = findViewById(R.id.tv1);
        fragmentManager = getSupportFragmentManager();
        mlllayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace();
                tv.setVisibility(View.GONE);
            }
        });
    }

    private void replace() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentName fragmentName = new FragmentName();
        fragmentTransaction.replace(R.id.flcontainer,fragmentName,"fragmentName").commit();
    }
}