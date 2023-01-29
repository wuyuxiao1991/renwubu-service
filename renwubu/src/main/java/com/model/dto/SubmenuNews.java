package com.model.dto;

import java.util.List;

/**
 * @author wuyuxiao
 */
public class SubmenuNews {
    String submenuGuid;
    String submenuName;
    List<NewsDetail> newsList;

    public SubmenuNews(String submenuGuid, String name, List<NewsDetail> news) {
        this.submenuGuid = submenuGuid;
        this.submenuName = name;
        this.newsList = news;
    }

    public String getSubmenuGuid() {
        return submenuGuid;
    }

    public void setSubmenuGuid(String submenuGuid) {
        this.submenuGuid = submenuGuid;
    }

    public String getSubmenuName() {
        return submenuName;
    }

    public void setSubmenuName(String submenuName) {
        this.submenuName = submenuName;
    }

    public List<NewsDetail> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsDetail> newsList) {
        this.newsList = newsList;
    }
}
