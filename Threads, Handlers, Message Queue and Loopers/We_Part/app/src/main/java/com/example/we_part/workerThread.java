package com.example.we_part;

import android.os.Handler;
import android.os.Looper;

public class workerThread extends Thread {


    private Handler handler;


    @Override
    public void run() {
        super.run();
        Looper.prepare();

        handler = new Handler(Looper.myLooper());

        Looper.loop();
    }


    public void addTasktoMessagequeue(Runnable task){

        if(handler !=null){
            handler.post(task);
        }
    }
}
