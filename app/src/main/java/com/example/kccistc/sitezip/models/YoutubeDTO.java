package com.example.kccistc.sitezip.models;

public class YoutubeDTO {
    String videoId;
    String title;
    String thumbnail;
    String publishedAt;

    // 글자가 깨졌을때 이걸로 불러움
    @Override
    public String toString() {
        return "YoutubeDTO{"+"videoId'"+videoId+'\''+
                ", title='" + title + '\'' +
                '}';
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
