package com.service;

import com.alibaba.fastjson.JSON;
import com.model.dto.NewsDetail;
import com.model.dto.NewsDto;
import com.model.request.AddOrUpdateRequest;
import com.persistence.entity.News;
import com.persistence.mapper.NewsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private SubmenuService submenuService;
    @Resource
    private NewsMapper newsMapper;

    public List<NewsDetail> getNewsBySubmenuGuid(String submenuGuid) {
        return newsMapper.findBySubmenuGuid(submenuGuid).stream().map(this::toDetail).collect(Collectors.toList());
    }

    public List<News> getNewsBySubmenuGuidAndTitle(String submenuGuid, String title) {
        return newsMapper.findBySubmenuGuidAndTitle(submenuGuid, title);
    }


    public NewsDetail getNewsByGuid(String newsGuid) {
        return toDetail(newsMapper.findByGuid(newsGuid));
    }

    public void deleteNews(String newsGuid) {
        newsMapper.updateDeleteStatus(newsGuid);
    }


    public List<NewsDto> pageQueryNews(List<String> submenuGuids, String searchKey, int pageNumber, int pageSize) {
        List<News> newsList = newsMapper.pageQueryNews(submenuGuids, searchKey, (pageNumber - 1) * pageSize, pageSize);
        return newsList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public NewsDetail addOrUpdateNews(AddOrUpdateRequest request, List<String> imageUrls) {
        List<News> newsList = getNewsBySubmenuGuidAndTitle(request.getSubmenuGuid(), request.getTitle());
        News news;
        if (!newsList.isEmpty()) {
            news = newsList.get(0);
            updateFields(news, request, imageUrls);
            newsMapper.updateById(news);
        } else {
            news = generateNews(request, imageUrls);
            newsMapper.insert(news);
        }
        return toDetail(news);
    }


    private void updateFields(News news, AddOrUpdateRequest request, List<String> imageUrls) {
        news.title = request.getTitle();
        news.images = JSON.toJSONString(imageUrls);
        news.deliverUserName = request.getDeliverUserName();
        news.text = request.getText();
    }


    private News generateNews(AddOrUpdateRequest request, List<String> imageUrls) {
        News news = new News();
        news.newsGuid=UUID.randomUUID().toString();
        news.title = request.getTitle();
        news.images = JSON.toJSONString(imageUrls);
        news.submenuGuid = request.getSubmenuGuid();
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
        newsDto.setDeliverUserName(news.deliverUserName);
        newsDto.setSubmenuName(submenuService.getSubmenusByGuid(news.submenuGuid).name);
        newsDto.setCreateTime(news.createTime);
        return newsDto;
    }

    public NewsDetail toDetail(News news) {
        if (news == null) {
            return null;
        }
        NewsDetail newsDetail = new NewsDetail();
        BeanUtils.copyProperties(news, newsDetail);
        newsDetail.setSubmenuName(submenuService.getSubmenusByGuid(news.submenuGuid) != null ? submenuService.getSubmenusByGuid(news.submenuGuid).name : null);
        newsDetail.setImages(JSON.parseObject(news.images, List.class));
        return newsDetail;
    }

}