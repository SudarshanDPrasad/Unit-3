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
        videoModels.add(new VideoModel("https://www.online-convert.com/downloadfile/2fe24bfa-45a5-4804-b2cd-25b9dfcf122b/f1bf1666-93a6-469d-96b9-7faef5d8f631",
                "Magic Video", "Treanding with his magics","0","400"));
        videoModels.add(new VideoModel("https://www.online-convert.com/downloadfile/2fe24bfa-45a5-4804-b2cd-25b9dfcf122b/5189b340-0be1-4490-a6d9-3e7d31daa75e",
                "Group Comedy", "Enjoying there college times ","0","220"));
        videoModels.add(new VideoModel("https://redirector.googlevideo.com/videoplayback?expire=1628377602&ei=or0OYZHKKPyVsfIP7_ySyAo&ip=107.161.26.193&id=o-AKJepWPekXpeRb_79iwerP5I6n59rjmD1Sv90_I3m8xE&itag=22&source=youtube&requiressl=yes&mh=jp&mm=31%2C26&mn=sn-vgqsknel%2Csn-ab5szn76&ms=au%2Conr&mv=u&mvi=6&pl=25&vprv=1&mime=video%2Fmp4&ns=HSsFchmOIey-40TSHfK4NUMG&ratebypass=yes&dur=328.214&lmt=1624588762487098&mt=1628355733&fvip=6&fexp=24001373%2C24007246&c=WEB&txp=5311224&n=xUGXaEtSaq_zyFL&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl&lsig=AG3C_xAwRQIgacbAGkTe_S9f6iNoKYbhvJNQ_WuWqKsmWVLpK57DHSECIQCrjryzTlnEWq2POTIlRglDYU7QrxUuCCHGG-TGd7QvCg%3D%3D&sig=AOq0QJ8wRQIhAKsBdEKEHyohjyoqRdAoovgelRR9zw0MpULnkyDlrwcNAiB4kGz8X3G1lHKT6y2aZi-PDDgBLHDt_vwCbiUdLrjRxw==&title=Nisha+Nikhil+Funny+Kannada+Tiktok+%28Part+8%29",
                "Nisha comedy queen", "Present Senero around people ","0","600"));
        videoModels.add(new VideoModel("https://www.online-convert.com/downloadfile/93f5f293-047c-48b9-bf19-64ad17e282bb/c89f18df-ef82-4c2f-80a3-2e998bbc9ee1",
                "Funny TikTok", "Funny TikTok Fails in India ","0","1200"));
        videoModels.add(new VideoModel("https://www.online-convert.com/downloadfile/93f5f293-047c-48b9-bf19-64ad17e282bb/0ede90bc-4964-429a-88fa-eaf123649a10",
                "Top 10 Best Pranks", "Top 10 Best Pranks in India Goes Viral ", "0", "350"));

    }

    private void initviews() {
        viewPager2 = findViewById(R.id.viewpager);
    }
}