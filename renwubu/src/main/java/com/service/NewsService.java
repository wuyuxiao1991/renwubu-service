package com.service;

import com.persistence.entity.News;
import com.persistence.mapper.NewsMapper;
import org.springframework.stereotype.Service;

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