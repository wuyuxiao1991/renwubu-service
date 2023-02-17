package com.model.request;


import java.util.List;

/**
 * @author wuyuxiao
 */


public class BasePageQueryResponse<T>{
    private List<T> list;
    private int totalCounts;

    public BasePageQueryResponse(List<T> list, int totalCounts) {
        this.list = list;
        this.totalCounts = totalCounts;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}