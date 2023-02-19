
package com.model.request;


/**
 * @author wuyuxiao
 */

public class PageQueryMilitaryStrengthGuaranteeRequest {
    private String searchKey;
    private String registrationTask;
    private String identity;
    private Integer pageNumber;
    private Integer pageSize;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
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


    public String getRegistrationTask() {
        return registrationTask;
    }

    public void setRegistrationTask(String registrationTask) {
        this.registrationTask = registrationTask;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}