package com.example.we_part;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnsend;
    private TextView tvname;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReciever localReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsend = findViewById(R.id.btnsend);
        tvname = findViewById(R.id.textView);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        RegisterLocalreciever();

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("Masai.com");
                intent.putExtra("data", "Hello Masai School");
                localBroadcastManager.sendBroadcast(intent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReciever);
    }

    private void RegisterLocalreciever() {
        localReciever = new LocalReciever();
        IntentFilter intentFilter = new IntentFilter("Masai.com");
        localBroadcastManager.registerReceiver(localReciever,intentFilter);
    }

    private class LocalReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent!=null){
                String data = intent.getStringExtra("data");
                tvname.setText(data);
            }
        }
    }
}

