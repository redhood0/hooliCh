package com.redhood.hoolicalendar.bean;

import java.util.List;

/**
 * @author cky
 * date 2019-12-11
 */
public class NewsList {


    /**
     * newslist : [{"author":"微众开源","id":111999,"title":"DataSphere Studio 0.60 版本发布","type":4,"authorid":3334446,"pubDate":"2019-12-11 09:21:34","commentCount":0},{"author":"局长","id":111998,"title":"微软将主办首场 Linux 会议 WSLConf，Ubuntu 提供支持","type":4,"authorid":2720166,"pubDate":"2019-12-11 08:28:15","commentCount":15},{"author":"xplanet","id":111997,"title":"Python 获 Mozilla 和扎克伯格夫妇 40 余万美金资助","type":4,"authorid":4105562,"pubDate":"2019-12-11 08:24:48","commentCount":7},{"author":"白开水不加糖","id":111996,"title":"Canonical 为受支持的 Raspberry Pi 开发板发布了新的 Ubuntu 镜像","type":4,"authorid":4252687,"pubDate":"2019-12-11 08:24:01","commentCount":16},{"author":"xplanet","id":111995,"title":"Chrome 浏览器新功能：电脑复制，手机粘贴","type":4,"authorid":4105562,"pubDate":"2019-12-11 08:22:54","commentCount":9},{"author":"oschina","id":111994,"title":"每日一博 | 一篇文章让你明白 CPU 缓存一致性协议 MESI","type":3,"authorid":1,"pubDate":"2019-12-11 08:21:15","commentCount":5,"object":3137582},{"author":"oschina","id":111993,"title":"G2Plot \u2014\u2014 开箱即用的图表库","type":1,"authorid":1,"pubDate":"2019-12-11 08:17:43","object":50138,"commentCount":0},{"author":"oschina","id":111992,"title":"码云推荐 | 来自国信证券的 Java 微服务框架 Zebra","type":0,"authorid":1,"pubDate":"2019-12-11 07:32:59","url":"https://gitee.com/gszebra/zebra","object":0,"commentCount":0},{"author":"局长","id":111991,"title":"CKEditor 5 v16.0.0 发布，支持插入代码块和增加受限编辑功能","type":4,"authorid":2720166,"pubDate":"2019-12-11 07:28:34","commentCount":5},{"author":"xplanet","id":111990,"title":"Spring Cloud Data Flow 2.3.0 GA 发布","type":4,"authorid":4105562,"pubDate":"2019-12-11 07:27:30","commentCount":0},{"author":"白开水不加糖","id":111989,"title":"Linux kernel 5.5-rc1 发布","type":4,"authorid":4252687,"pubDate":"2019-12-11 07:26:41","commentCount":1},{"author":"xplanet","id":111988,"title":"Vulkan 1.1.130 发布，图形 API 规范","type":4,"authorid":4105562,"pubDate":"2019-12-11 07:25:56","commentCount":0},{"author":"白开水不加糖","id":111987,"title":"Traefik 2.0.7 发布，HTTP 反向代理与负载均衡工具","type":4,"authorid":4252687,"pubDate":"2019-12-11 07:25:17","commentCount":5},{"author":"白开水不加糖","id":111986,"title":"图像编辑器 GIMP 2.10.14.1 发布","type":4,"authorid":4252687,"pubDate":"2019-12-11 07:24:27","commentCount":4},{"author":"xplanet","id":111985,"title":"PostgreSQL JDBC 42.2.9 发布","type":4,"authorid":4105562,"pubDate":"2019-12-11 07:23:43","commentCount":6},{"author":"xplanet","id":111984,"title":"Emulator 29.2.12 稳定版发布，启用 Google Maps UI","type":4,"authorid":4105562,"pubDate":"2019-12-11 07:22:33","commentCount":1},{"author":"kokjuis","id":111982,"title":"getty 发布，一个完全基于 java 实现的 aio 框架","type":4,"authorid":2276021,"pubDate":"2019-12-10 17:44:24","commentCount":4},{"author":"metinfo666","id":111979,"title":"米拓企业建站系统 V7.0.0，开源免费，支持 10 合 1 建站","type":4,"authorid":4189863,"pubDate":"2019-12-10 13:51:05","commentCount":18},{"author":"ldh_123","id":111977,"title":"Auto Maker 1.0.5 版本发布， 强大的 spring cloud oauth 脚手架","type":4,"authorid":1028496,"pubDate":"2019-12-10 11:38:42","commentCount":4},{"author":"依剑_听雨","id":111976,"title":"notadd-cli 1.0 发布，Typescript 生成 graphql 配置","type":4,"authorid":2352515,"pubDate":"2019-12-10 11:30:50","commentCount":4}]
     * notice : {"referCount":0,"replyCount":0,"msgCount":0,"fansCount":0}
     *
     */

    private NoticeBean notice;
    private List<NewslistBean> newslist;

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NoticeBean {
        /**
         * referCount : 0  未读@我数
         * replyCount : 0  未读评论数
         * msgCount : 0  未读私信数
         * fansCount : 0  新增粉丝数
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

    public static class NewslistBean {
        /**
         * author : 微众开源    投递者名称
         * id : 111999  新闻id
         * title : DataSphere Studio 0.60 版本发布      新闻标题
         * type : 4     新闻类型 [0-链接新闻|1-软件推荐|2-讨论区帖子|3-博客|4-普通新闻|7-翻译文章]
         * authorid : 3334446       	投递者编号
         * pubDate : 2019-12-11 09:21:34        发布日期
         * commentCount : 0  评论数
         * object : 3137582
         * url : https://gitee.com/gszebra/zebra
         */

        private String author;
        private int id;
        private String title;
        private int type;
        private int authorid;
        private String pubDate;
        private int commentCount;
        private int object;
        private String url;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getAuthorid() {
            return authorid;
        }

        public void setAuthorid(int authorid) {
            this.authorid = authorid;
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

        public int getObject() {
            return object;
        }

        public void setObject(int object) {
            this.object = object;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "NewslistBean{" +
                    "author='" + author + '\'' +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", authorid=" + authorid +
                    ", pubDate='" + pubDate + '\'' +
                    ", commentCount=" + commentCount +
                    ", object=" + object +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
