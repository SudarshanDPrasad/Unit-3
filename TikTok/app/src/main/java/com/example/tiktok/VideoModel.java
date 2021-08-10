package com.example.tiktok;

public class VideoModel {

    String VideoUrl, title, desc, like, comments;

    public VideoModel(String videoUrl, String title, String desc, String like, String comments) {
        VideoUrl = videoUrl;
        this.title = title;
        this.desc = desc;
        this.like = like;
        this.comments = comments;
    }

    public void setVideoUrl(String videoUrl) {
        VideoUrl = videoUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getLike() {
        return like;
    }

    public String getComments() {
        return comments;
    }
}
