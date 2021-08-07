package com.example.tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class TikTokActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private ArrayList<VideoModel> videoModels = new ArrayList<>();
    private VideoAdaptor videoAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initviews();
        buildata();
        setAdaptor();

    }

    private void setAdaptor() {
        videoAdaptor = new VideoAdaptor(videoModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        viewPager2.setAdapter(videoAdaptor);

    }

    private void buildata() {
        videoModels.add(new VideoModel("https://www.online-convert.com/downloadfile/582113a5-4b08-467b-b6fa-1436e1c4da4a/cc372ad2-146b-46e3-81fb-e2f7ee03ddaf",
                "Funny one", "Treanding"));
        videoModels.add(new VideoModel("https://www.online-convert.com/downloadfile/a581b25b-17fe-4f6e-9498-59bcf9be2d9f/3dbe2fd6-7682-41f9-a6ba-fa65980bec00",
                "Funny one", "Treanding"));

    }

    private void initviews() {
        viewPager2 = findViewById(R.id.viewpager);
    }
}