package com.redhood.hoolicalendar.bean;

import java.util.List;

/**
 * @author cky
 * date 2019-12-11
 */
public class NewsList {


    /**
     * newslist : [{"author":"xplanet","id":112035,"title":"Dart 2.7 发布，新增扩展方法支持","type":4,"authorid":4105562,"pubDate":"2019-12-13 07:43:40","commentCount":0},{"author":"白开水不加糖","id":112034,"title":"Visual Studio 2019 for Mac 8.4 Preview 4 发布","type":4,"authorid":4252687,"pubDate":"2019-12-13 07:41:01","commentCount":1},{"author":"白开水不加糖","id":112033,"title":"VirtualBox 6.1.0 发布，开源虚拟机","type":4,"authorid":4252687,"pubDate":"2019-12-13 07:40:16","commentCount":1},{"author":"xplanet","id":112032,"title":"ReSharper Ultimate 2019.3 发布","type":4,"authorid":4105562,"pubDate":"2019-12-13 07:38:17","commentCount":1},{"author":"xplanet","id":112031,"title":"TensorFlow 2.1.0-rc1 发布","type":4,"authorid":4105562,"pubDate":"2019-12-13 07:37:16","commentCount":0},{"author":"白开水不加糖","id":112030,"title":"Traefik 2.1.0 发布，HTTP 反向代理与负载均衡工具","type":4,"authorid":4252687,"pubDate":"2019-12-13 07:36:36","commentCount":0},{"author":"xplanet","id":112029,"title":"SonarQube 7.9.2 LTS 发布，代码质量管理平台","type":4,"authorid":4105562,"pubDate":"2019-12-13 07:35:51","commentCount":0},{"author":"xplanet","id":112028,"title":"Ionic 5.0.0 beta.2 发布，混合移动应用前端框架","type":4,"authorid":4105562,"pubDate":"2019-12-13 07:34:04","commentCount":0},{"author":"huangzhhui","id":112026,"title":"Hyperf 发布 v1.1.10 版本，企业级的 PHP 微服务云原生协程框架","type":4,"authorid":4151378,"pubDate":"2019-12-12 17:26:45","commentCount":2},{"author":"冰力","id":112025,"title":"Hunt Redis 1.0.0 发布，D 语言 Redis 客户端","type":4,"authorid":118197,"pubDate":"2019-12-12 16:52:26","commentCount":8},{"author":"软践","id":112024,"title":"微信模块 Oejia_wx v0.6 发布，全面支持多 worker 运行模式及异步通知 ","type":4,"authorid":105889,"pubDate":"2019-12-12 15:11:03","commentCount":0},{"author":"漆工","id":112023,"title":"React UI 库 React Suite 4.1.4 版本更新","type":4,"authorid":556016,"pubDate":"2019-12-12 13:09:10","commentCount":2},{"author":"努力加贝","id":112022,"title":"xplay 1.0.7 发布，专为树莓派(RPI)与 Windows 系统设计的多媒体播放器","type":4,"authorid":2899602,"pubDate":"2019-12-12 11:55:30","commentCount":0},{"author":"MetInfo","id":112019,"title":"米拓小程序插件正式发布，免费，调用网站内容，支持微信、百度6端小程序","type":4,"authorid":659437,"pubDate":"2019-12-12 11:11:51","commentCount":0},{"author":"xplanet","id":112018,"title":"微软首款 Office 应用程序登陆 Linux","type":4,"authorid":4105562,"pubDate":"2019-12-12 08:38:31","commentCount":26},{"author":"局长","id":112017,"title":"Debian 正在投票是否支持非 systemd 初始化系统","type":4,"authorid":2720166,"pubDate":"2019-12-12 08:37:23","commentCount":15},{"author":"局长","id":112016,"title":"WireGuard 已被合并至 net-next，即将进入 Linux 5.6","type":4,"authorid":2720166,"pubDate":"2019-12-12 08:35:33","commentCount":13},{"author":"局长","id":112015,"title":"微软将中止支持 .NET Core 2.2，建议开发者升级至 .NET Core 3.1","type":4,"authorid":2720166,"pubDate":"2019-12-12 08:34:08","commentCount":6},{"author":"oschina","id":112014,"title":"每日一博 | 反应式架构(1)：基本概念介绍","type":3,"authorid":1,"pubDate":"2019-12-12 08:32:49","commentCount":15,"object":3141289},{"author":"oschina","id":112013,"title":"Lars \u2014\u2014 基于 C++ 负载均衡远程服务器调度系统","type":1,"authorid":1,"pubDate":"2019-12-12 08:27:19","object":50197,"commentCount":0}]
     * notice : {"referCount":0,"replyCount":0,"msgCount":0,"fansCount":0}
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

    public static class NewslistBean {
        /**
         * author : xplanet
         * id : 112035
         * title : Dart 2.7 发布，新增扩展方法支持
         * type : 4
         * authorid : 4105562
         * pubDate : 2019-12-13 07:43:40
         * commentCount : 0
         * object : 3141289
         */

        private String author;
        private int id;
        private String title;
        private int type;
        private int authorid;
        private String pubDate;
        private int commentCount;
        private int object;

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
    }
}
