package com.model.request;


/**
 * @author wuyuxiao
 */

public class PageQueryTrainingDetailsRequest {
    private String searchKey;
    private String year;
    private String province;
    private String city;
    private String district;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String  district) {
        this.district = district;
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