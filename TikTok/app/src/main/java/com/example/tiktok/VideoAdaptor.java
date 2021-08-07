package com.example.tiktok;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoAdaptor extends RecyclerView.Adapter<ViewHodler> {

    private ArrayList<VideoModel> videoModelArrayList;

    public VideoAdaptor(ArrayList<VideoModel> videoModelArrayList) {
        this.videoModelArrayList = videoModelArrayList;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        VideoModel videoModel = videoModelArrayList.get(position);
        holder.setData(videoModel);
    }


    @Override
    public int getItemCount() {
        return videoModelArrayList.size();
    }
}
