package com.example.dawnnewswebscrapping;

class ParseItem {

    private String imgUrl,authername,description;
    private String title;
    private String detailUrl,time;

    public ParseItem(String imgUrl, String authername, String description, String title, String detailUrl, String time) {
        this.imgUrl = imgUrl;
        this.authername = authername;
        this.description = description;
        this.title = title;
        this.detailUrl = detailUrl;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAuthername() {
        return authername;
    }

    public void setAuthername(String authername) {
        this.authername = authername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
}
