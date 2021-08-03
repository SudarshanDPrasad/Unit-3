package com.example.we_part.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.we_part.Model;
import com.example.we_part.R;

public class PreviewActivity extends AppCompatActivity {

    private TextView tvname,tvage,tvgrade,tvpercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initviews();
        getDatafromIntent();
    }

    private void getDatafromIntent() {
        Model model = (Model) getIntent().getSerializableExtra("model");
        tvname.setText(model.getName());
        tvage.setText(model.getAge()+"");
        tvgrade.setText(model.getGrade());
        tvpercentage.setText(model.getPercentage());
    }

    private void initviews() {
        tvname = findViewById(R.id.tvStudentName);
        tvage = findViewById(R.id.tvStudentAge);
        tvgrade = findViewById(R.id.tvStudentGrade);
        tvpercentage = findViewById(R.id.tvStudentPercentage);

    }
}