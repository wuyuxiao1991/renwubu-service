package com.model.request;


import com.model.dto.NewsDto;

import java.util.List;

/**
 * @author wuyuxiao
 */


public class PageQueryNewsResponse {
    private List<NewsDto> newsDtos;
    private int totalCounts;

    public PageQueryNewsResponse(List<NewsDto> newsDtos, int totalCounts) {
        this.newsDtos = newsDtos;
        this.totalCounts = totalCounts;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<NewsDto> getNewsDtos() {
        return newsDtos;
    }

    public void setNewsDtos(List<NewsDto> newsDtos) {
        this.newsDtos = newsDtos;
    }
}