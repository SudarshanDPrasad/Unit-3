package com.example.we_part;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2;
    private workerThread workerThread;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        workerThread = new workerThread();
        workerThread.start();
        Log.d(TAG, "run");

    }

    private void initviews() {
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTasktoMessagequeue(task1);
                Toast.makeText(MainActivity.this,"task 1" + Thread.currentThread().getName(),Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTasktoMessagequeue(task2);
                Toast.makeText(MainActivity.this,"task 2 " + Thread.currentThread().getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private Runnable task1 = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "task 1" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable task2 = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "task 2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}