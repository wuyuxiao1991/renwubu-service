package com.model.request;


import lombok.Data;

/**
 * @author wuyuxiao
 */

public class AddOrUpdateRequest {
    private String title;
    private String submenuGuid;
    private String deliverUserName;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmenuGuid() {
        return submenuGuid;
    }

    public void setSubmenuGuid(String submenuGuid) {
        this.submenuGuid = submenuGuid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDeliverUserName() {
        return deliverUserName;
    }

    public void setDeliverUserName(String deliverUserName) {
        this.deliverUserName = deliverUserName;
    }
}