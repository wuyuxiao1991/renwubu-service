package com.model.request;


/**
 * @author wuyuxiao
 */

public class PageQueryYearlyPlanDetailsRequest {
    private String searchKey;
    private String year;
    private String month;
    private String identity;
    private Integer pageNumber;
    private Integer pageSize;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getPageNumber() {
        if (this.pageNumber == null) {
            return 1;
        }
        return this.pageNumber;
    }

    public Integer getPageSize() {
        if (this.pageSize == null) {
            return 10;
        }
        return this.pageSize;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}