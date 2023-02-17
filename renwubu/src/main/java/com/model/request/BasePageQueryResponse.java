package com.model.request;


import com.model.dto.NewsDto;

import java.util.List;

/**
 * @author wuyuxiao
 */


public class BasePageQueryResponse<T>{
    private List<T> list;
    private int totalCounts;

    public BasePageQueryResponse(List<T> newsDtos, int totalCounts) {
        this.list = newsDtos;
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