package com.redhood.hoolicalendar.bean;

import java.util.HashMap;

/**
 * @author cky
 * date 2019-12-20
 */
public class TweetTalkBean {
    String title;
    HashMap<String,String> hashMap;
    String person;

    public TweetTalkBean(String title, HashMap<String, String> hashMap, String person) {
        this.title = title;
        this.hashMap = hashMap;
        this.person = person;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}

