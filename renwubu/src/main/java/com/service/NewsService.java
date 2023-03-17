package com.service;

import com.alibaba.fastjson.JSON;
import com.model.dto.NewsDetail;
import com.model.dto.NewsDto;
import com.model.request.AddOrUpdateRequest;
import com.persistence.entity.News;
import com.persistence.mapper.NewsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author wuyuxiao
 */
@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    public List<NewsDetail> getNewsByThirdMenuGuid(String thirdMenuGuid) {
        return newsMapper.findByThirdMenuGuid(thirdMenuGuid).stream().map(this::toDetail).collect(Collectors.toList());
    }

    public List<News> getNewsByThirdMenuGuidAndTitle(String thirdMenuGuid, String title) {
        return newsMapper.findBythirdMenuGuidAndTitle(thirdMenuGuid, title);
    }


    public NewsDetail getNewsByGuid(String newsGuid) {
        return toDetail(newsMapper.findByGuid(newsGuid));
    }

    public void deleteNews(String newsGuid) {
        newsMapper.updateDeleteStatus(newsGuid);
    }


    public List<NewsDto> pageQueryNews(String thirdMenuGuid, String searchKey, int pageNumber, int pageSize) {
        List<News> newsList = newsMapper.pageQueryNews(thirdMenuGuid, searchKey, (pageNumber - 1) * pageSize, pageSize);
        return newsList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public int queryNewsTotalCount(String thirdMenuGuid, String searchKey) {
        return newsMapper.queryNewsTotalCount(thirdMenuGuid, searchKey);
    }

    public NewsDetail addOrUpdateNews(AddOrUpdateRequest request, List<String> imageUrls) {
        List<News> newsList = getNewsByThirdMenuGuidAndTitle(request.getThirdMenuGuid(), request.getTitle());
        News news;
        if (!newsList.isEmpty()) {
            news = newsList.get(0);
            if (imageUrls.size() > 0) {
                updateAllFields(news, request, imageUrls);
            } else {
                updateText(news, request);
            }
            newsMapper.updateById(news);
        } else {
            news = generateNews(request, imageUrls);
            newsMapper.insert(news);
        }
        return toDetail(news);
    }


    private void updateAllFields(News news, AddOrUpdateRequest request, List<String> imageUrls) {
        news.title = request.getTitle();
        news.images = JSON.toJSONString(imageUrls);
        news.deliverUserName = request.getDeliverUserName();
        news.text = request.getText();
    }

    private void updateText(News news, AddOrUpdateRequest request) {
        news.title = request.getTitle();
        news.deliverUserName = request.getDeliverUserName();
        news.text = request.getText();
    }


    private News generateNews(AddOrUpdateRequest request, List<String> imageUrls) {
        News news = new News();
        news.newsGuid = UUID.randomUUID().toString();
        news.title = request.getTitle();
        news.images = JSON.toJSONString(imageUrls);
        news.thirdMenuGuid = request.getThirdMenuGuid();
        news.deliverUserName = request.getDeliverUserName();
        news.text = request.getText();
        return news;
    }

    private NewsDto toDto(News news) {
        if (news == null) {
            return null;
        }
        NewsDto newsDto = new NewsDto();
        newsDto.setNewsGuid(news.newsGuid);
        newsDto.setTitle(news.title);
        newsDto.setText(news.text);
        newsDto.setImages(JSON.parseObject(news.images, List.class));
        newsDto.setDeliverUserName(news.deliverUserName);
        newsDto.setCreateTime(news.createTime);
        return newsDto;
    }

    public NewsDetail toDetail(News news) {
        if (news == null) {
            return null;
        }
        NewsDetail newsDetail = new NewsDetail();
        BeanUtils.copyProperties(news, newsDetail);
        newsDetail.setFiles(JSON.parseObject(news.images, List.class));
        return newsDetail;
    }

}