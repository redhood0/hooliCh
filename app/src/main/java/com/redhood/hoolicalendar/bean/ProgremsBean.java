package com.redhood.hoolicalendar.bean;

import java.util.List;

public class ProgremsBean {

    List<ProgremBean> projectlist;

    public List<ProgremBean> getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(List<ProgremBean> projectlist) {
        this.projectlist = projectlist;
    }

    public static class ProgremBean {
//        "description": "Android SDK",
//                "name": "Android SDK",
//                "url": "http://oschina.org/p/android"
        String description;
        String name;
        String url;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
