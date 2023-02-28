package com.model.request;


/**
 * @author wuyuxiao
 */

public class AddOrUpdateRequest {
    private String title;
    private String thirdMenuGuid;
    private String deliverUserName;
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThirdMenuGuid() {
        return thirdMenuGuid;
    }

    public void setThirdMenuGuid(String thirdMenuGuid) {
        this.thirdMenuGuid = thirdMenuGuid;
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