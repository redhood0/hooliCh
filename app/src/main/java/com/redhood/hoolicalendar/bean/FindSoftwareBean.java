package com.redhood.hoolicalendar.bean;

public class FindSoftwareBean {
    int imgId;
    String title;
    String content;

    public FindSoftwareBean(int imgId, String title, String content) {
        this.imgId = imgId;
        this.title = title;
        this.content = content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
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
}
