package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.persistence.entity.News;
import com.persistence.mapper.NewsMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public
class NewsService {
    @Resource
    private NewsMapper newsMapper;

    public List<News> getNews(String submenuGuid) {
        return newsMapper.findBySubmenuGuid(submenuGuid);
    }
}