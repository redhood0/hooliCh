package com.redhood.hoolicalendar.bean;

/**
 * @author cky
 * date 2019-12-12
 */
public class TweetDetail {

    /**
     * author : 胖达panda
     * id : 20894515
     * portrait : https://static.oschina.net/uploads/user/636/1272314_50.jpg?t=1521391550000
     * authorid : 1272314
     * body : <img src="http://www.oschina.net/js/ke/plugins/emoticons/0.gif" alt="0">
     * pubDate : 2019-12-12 15:51:24
     * commentCount : 0
     */

    private String author;
    private int id;
    private String portrait;
    private int authorid;
    private String body;
    private String pubDate;
    private int commentCount;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
