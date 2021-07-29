package com.example.sendbroadcastbetweenapps2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Hey i am from App2 ",Toast.LENGTH_SHORT).show();
    }
}
