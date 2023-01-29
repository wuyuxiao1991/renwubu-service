package com.model.request;


import lombok.Data;

/**
 * @author wuyuxiao
 */

public class PageQueryNewsRequest {
    private String menuName;
    private String searchKey;
    private Integer pageNumber;
    private Integer pageSize ;
    private String identity;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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