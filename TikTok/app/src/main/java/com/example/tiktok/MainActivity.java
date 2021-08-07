package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUserName, etPassword;
    private Button btnLogin;
    private CheckBox remember;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.EtUserName);
        etPassword = findViewById(R.id.EtPassword);
        remember = findViewById(R.id.checkbox1);
        btnLogin = findViewById(R.id.btnLogin);

        SharedPreferences sharedPreferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = sharedPreferences.getString("remember","");
        if(checkbox.equals("true")){

            Intent intent = new Intent(MainActivity.this, TikTokActivity.class);
            startActivity(intent);
        }else if(checkbox.equals("false")){
            Toast.makeText(MainActivity.this,"plaease sign in",Toast.LENGTH_SHORT).show();
        }

            remember.setOnCheckedChangeListener((compoundButton, b) -> {
                if (compoundButton.isChecked()) {

                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                } else if (!compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                }
            });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TikTokActivity.class);
                startActivity(intent);
            }
        });
    }
}