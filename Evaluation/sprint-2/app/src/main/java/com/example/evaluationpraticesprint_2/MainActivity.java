package com.example.evaluationpraticesprint_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);

        textView.animate().translationX(3000).translationY(3000).setStartDelay(3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,ItemListActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
    public void setData(String name) {
        this.name = name;
    }

    public String getData(){
        return name;
    }

}