package com.redhood.hoolicalendar.bean;

import java.util.List;

/**
 * @author cky
 * date 2019-12-12
 */
public class NewsDetail {

    /**
     * author : 努力加贝
     * id : 112022
     * authorid : 2899602
     * title : xplay 1.0.7 发布，专为树莓派(RPI)与 Windows 系统设计的多媒体播放器
     * body : <style type='text/css'>pre {white-space:pre-wrap;word-wrap:break-word;}</style><p>xplay&nbsp;<a href="https://gitee.com/nljb/xplay/tree/v1.0.7.v20191211" rel="nofollow">v1.0.7.v20191211</a>&nbsp;发布了，此版本更新内容：</p>

     * pubDate : 2019-12-12 11:55:30
     * favorite : 0
     * url : https://www.oschina.net/news/112022/xplay-1-0-7-released
     * relativies : [{"title":"若依管理系统 1.0.7 发布，新增岗位管理","url":"https://www.oschina.net/news/94873/ruoyi-1-0-7-released"},{"title":"mpvue 1.0.7 发布，基于 Vue.js 的小程序开发框架","url":"https://www.oschina.net/news/94518/mpvue-1-0-7-released"},{"title":"jSqlBox 1.0.7 版发布， 一个Java持久层工具 ","url":"https://www.oschina.net/news/94128/jsqlbox-1-0-7"},{"title":"Sylius v1.0.7 发布，开源 PHP 电子商务网站框架","url":"https://www.oschina.net/news/91998/sylius-1-0-7-released"},{"title":"PHP 异步协程框架 Group-Co 更新至 v1.0.7","url":"https://www.oschina.net/news/91766/group-co-1-0-7"},{"title":"Hikyuu 1.0.7 发布，量化交易研究框架","url":"https://www.oschina.net/news/91524/hikyuu-1-0-7"},{"title":"PHPRAP v1.0.7 版本发布，新增数据字典功能","url":"https://www.oschina.net/news/91090/phprap-1-0-7"},{"title":"hi-nginx-1.0.7 发布，基于 nginx 的多语言通用服务器","url":"https://www.oschina.net/news/87615/hi-nginx-1-0-7"},{"title":"ActFramework 1.0.7 发布，ebean 插件支持 Druid","url":"https://www.oschina.net/news/83505/actframework-1-0-7"},{"title":"Kotlin 1.0.7 发布，基于 JVM 的编程语言","url":"https://www.oschina.net/news/82931/kotlin-1-0-7-is-out"}]
     * commentCount : 0
     * notice : {"referCount":0,"replyCount":0,"msgCount":0,"fansCount":0}
     */

    private String author;
    private int id;
    private int authorid;
    private String title;
    private String body;
    private String pubDate;
    private int favorite;
    private String url;
    private int commentCount;
    private NoticeBean notice;
    private List<RelativiesBean> relativies;

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

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public List<RelativiesBean> getRelativies() {
        return relativies;
    }

    public void setRelativies(List<RelativiesBean> relativies) {
        this.relativies = relativies;
    }

    public static class NoticeBean {
        /**
         * referCount : 0
         * replyCount : 0
         * msgCount : 0
         * fansCount : 0
         */

        private int referCount;
        private int replyCount;
        private int msgCount;
        private int fansCount;

        public int getReferCount() {
            return referCount;
        }

        public void setReferCount(int referCount) {
            this.referCount = referCount;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getMsgCount() {
            return msgCount;
        }

        public void setMsgCount(int msgCount) {
            this.msgCount = msgCount;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }
    }

    public static class RelativiesBean {
        /**
         * title : 若依管理系统 1.0.7 发布，新增岗位管理
         * url : https://www.oschina.net/news/94873/ruoyi-1-0-7-released
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
