package com.redhood.hoolicalendar.bean;

/**
 * @author cky
 * date 2019-12-13
 */
public class Oauth2Token {

    /**
     * gender : MALE
     * nickname : robot_man
     * location : 江苏 南京
     * avatar : https://static.oschina.net/uploads/user/1854/3708595_50.jpeg?t=1508155510000
     * source : OSCHINA
     * blog : https://my.oschina.net/u/3708595
     * uuid : 3708595
     * email : 17835789-d843-4aa0-8e1f-2b4d44b48e2d
     * token : {"accessToken":"4673df12-a662-4cc9-8472-1d26bfe6461b","uid":"3708595","expireIn":379894,"refreshToken":"78af8587-6ae6-4fc4-bf5d-4ef221c23b6a"}
     * username : robot_man
     */

    private String gender;
    private String nickname;
    private String location;
    private String avatar;
    private String source;
    private String blog;
    private String uuid;
    private String email;
    private TokenBean token;
    private String username;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TokenBean getToken() {
        return token;
    }

    public void setToken(TokenBean token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class TokenBean {
        /**
         * accessToken : 4673df12-a662-4cc9-8472-1d26bfe6461b
         * uid : 3708595
         * expireIn : 379894
         * refreshToken : 78af8587-6ae6-4fc4-bf5d-4ef221c23b6a
         */

        private String accessToken;
        private String uid;
        private int expireIn;
        private String refreshToken;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getExpireIn() {
            return expireIn;
        }

        public void setExpireIn(int expireIn) {
            this.expireIn = expireIn;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
    }
}
