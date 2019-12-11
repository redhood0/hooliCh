package com.redhood.hoolicalendar.bean;

import java.util.List;

/**
 * @author cky
 * date 2019-12-11
 */
public class MyInformation {

    /**
     * gender : 1       性别：1-男，2-女
     * joinTime : 2019-09-19 19:15:04       加入时间
     * city : 南京        	城市
     * fansCount : 0    粉丝数
     * portrait : https://static.oschina.net/uploads/user/2107/4215606_50.jpg?t=1568891704000       头像
     * expertise : []       专长领域
     * platforms : []       开发平台
     * uid : 4215606        被查询用户id
     * lastLoginTime : 2019-12-11 15:41:43      	最近登录时间
     * province : 江苏        	省份
     * name : dyoan43       用户名称
     * followersCount : 0       关注数
     * favoriteCount : 0    收藏数
     * notice : {"referCount":0,"replyCount":0,"msgCount":0,"fansCount":0}
     */

    private int gender;
    private String joinTime;
    private String city;
    private int fansCount;
    private String portrait;
    private int uid;
    private String lastLoginTime;
    private String province;
    private String name;
    private int followersCount;
    private int favoriteCount;
    private NoticeBean notice;
    private List<?> expertise;
    private List<?> platforms;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public List<?> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<?> expertise) {
        this.expertise = expertise;
    }

    public List<?> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<?> platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "MyInformation{" +
                "gender=" + gender +
                ", joinTime='" + joinTime + '\'' +
                ", city='" + city + '\'' +
                ", fansCount=" + fansCount +
                ", portrait='" + portrait + '\'' +
                ", uid=" + uid +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", province='" + province + '\'' +
                ", name='" + name + '\'' +
                ", followersCount=" + followersCount +
                ", favoriteCount=" + favoriteCount +
                ", notice=" + notice +
                ", expertise=" + expertise +
                ", platforms=" + platforms +
                '}';
    }

    public static class NoticeBean {
        /**
         * referCount : 0 未读@我数
         * replyCount : 0 未读评论数
         * msgCount : 0 未读私信数
         * fansCount : 0 新增粉丝数
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
}
