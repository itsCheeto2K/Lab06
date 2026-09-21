package com.example.lab06;

import java.io.Serializable;

public class Article implements Serializable {
    private String title;
    private String content;
    private int imgCover;
    private int viewCount;

    public Article(String title, String content, int imgCover, int viewCount) {
        this.title = title;
        this.content = content;
        this.imgCover = imgCover;
        this.viewCount = viewCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImgCover() {
        return imgCover;
    }

    public void setImgCover(int imgCover) {
        this.imgCover = imgCover;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void increaseView() {
        this.viewCount++;
    }
}
