package com.example.kccistc.sitezip;

public class ExcerciseItem {

    private String imgUrl;
    private String imgprofile;
    private String title;
    private String intro;
    private String Url;

    public ExcerciseItem(String imgUrl, String title, String intro, String imgprofile, String url) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.intro = intro;
        this.imgprofile = imgprofile;
        this.Url = url;

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public String getImgprofile() {
        return imgprofile;
    }

    public String getUrl() {
        return Url;
    }
}
