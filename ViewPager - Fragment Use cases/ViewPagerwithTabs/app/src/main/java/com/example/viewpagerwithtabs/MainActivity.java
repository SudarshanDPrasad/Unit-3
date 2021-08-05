package com.example.viewpagerwithtabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        setPagerAdapter();
    }

    private void setPagerAdapter() {
        PagerAdaptor pagerAdaptor = new PagerAdaptor(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(pagerAdaptor);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==0){
                    tab.setText("Names");
                }else  if(position==1){

                        tab.setText("Places");
                }else{
                    if(position==2)
                        tab.setText("Tourisit Places");
                }

            }
        }).attach();
    }

    private void initviews() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
    }
}