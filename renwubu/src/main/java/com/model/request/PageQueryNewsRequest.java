package com.model.request;


/**
 * @author wuyuxiao
 */

public class PageQueryNewsRequest {
    private String thirdMenuGuid;
    private String searchKey;
    private Integer pageNumber;
    private Integer pageSize ;
    private String identity;

    public String getThirdMenuGuid() {
        return thirdMenuGuid;
    }

    public void setThirdMenuGuid(String thirdMenuGuid) {
        this.thirdMenuGuid = thirdMenuGuid;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getPageNumber() {
        if (this.pageNumber == null) {return 1;}
        return this.pageNumber;
    }

    public Integer getPageSize() {
        if (this.pageSize == null) {return 10;}
        return this.pageSize;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}