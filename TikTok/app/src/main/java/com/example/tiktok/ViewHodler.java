package com.example.tiktok;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHodler extends RecyclerView.ViewHolder {

    private VideoView videoView;
    private TextView tvtitle, tvdesc, likes, comments;
    private ProgressBar progressBar;
    private String TAG = "";
    private View like;


    public ViewHodler(@NonNull View itemView) {
        super(itemView);
        initviews(itemView);
    }

    private void initviews(View itemView) {
        videoView = itemView.findViewById(R.id.videoview);
        tvtitle = itemView.findViewById(R.id.tvName);
        tvdesc = itemView.findViewById(R.id.tvDescripition);
        likes = itemView.findViewById(R.id.likes);
        comments = itemView.findViewById(R.id.comments);
        progressBar = itemView.findViewById(R.id.progressbar);
        like = itemView.findViewById(R.id.like);

    }

    public void setData(VideoModel videoModel) {
        tvtitle.setText(videoModel.getTitle());
        tvdesc.setText(videoModel.getDesc());
        videoView.setVideoPath(videoModel.getVideoUrl());
        likes.setText(videoModel.getLike());
        comments.setText(videoModel.getComments());


        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likes.setText(videoModel.getLike() + 1);
            }
        });

        MediaPlayer mediaPlayer = new MediaPlayer();


        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                progressBar.setVisibility(View.GONE);
                mediaPlayer.start();
                //     // https://video.online-convert.com/convert-to-mp4
                videoView.start();
                Log.d(TAG, "Sudarshan");
            }
        });


        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoView.start();
            }
        });
    }
}
