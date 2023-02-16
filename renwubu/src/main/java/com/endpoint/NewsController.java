package com.endpoint;

import com.model.BaseResponse;
import com.model.dto.NewsDetail;
import com.model.dto.NewsDto;
import com.model.request.*;
import com.persistence.entity.Menu;
import com.persistence.entity.Submenu;
import com.service.MenuService;
import com.service.NewsService;
import com.service.SubmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class NewsController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private SubmenuService submenuService;
    @Autowired
    private NewsService newsService;

    @Value("${image.url}")
    private String url;

    @PostMapping("/page_query_news")
    public BaseResponse<PageQueryNewsResponse> pageQueryNews(@RequestBody PageQueryNewsRequest request) {
        try {
            //1.根据菜单名找到母菜单
            Menu menu = menuService.getMenus(request.getMenuName(), request.getIdentity());

            //2.根据母菜单找到子菜单
            List<Submenu> submenuList = submenuService.getSubmenusByMenuGuid(menu.menuGuid);

            //3.分页查询news
            List<NewsDto> newsList = newsService.pageQueryNews(submenuList.stream().map(p -> p.submenuGuid).collect(Collectors.toList()),
                    request.getSearchKey(), request.getPageNumber(), request.getPageSize());

            int count = newsService.queryNewsTotalCount(submenuList.stream().map(p -> p.submenuGuid).collect(Collectors.toList()),
                    request.getSearchKey());

            return BaseResponse.ok(new PageQueryNewsResponse(newsList, count));
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    @PostMapping("/query_news_detail")
    public BaseResponse<NewsDetail> queryNewsDetail(@RequestBody QueryNewsDetailRequest request) {
        try {
            NewsDetail newsDetail = newsService.getNewsByGuid(request.getNewsGuid());
            return BaseResponse.ok(newsDetail);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    @PostMapping("/delete_news")
    public BaseResponse<Boolean> deleteNews(@RequestBody DeleteNewsRequest request) {
        try {
            newsService.deleteNews(request.getNewsGuid());
            return BaseResponse.ok(true);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

    @PostMapping("/add_or_update_news")
    public BaseResponse<NewsDetail> addOrUpdateNews(@RequestPart(value = "images", required = false) MultipartFile[] files, @RequestPart("content") AddOrUpdateRequest request) {
        try {
//            1.上传图片到tomcat路径下
            List<String> imageUrls = new ArrayList<>();
            if(files!=null) {
                long count = Arrays.stream(files)
                        .map(MultipartFile::getOriginalFilename).filter(Objects::nonNull).count();
                if (count > 0) {
                    for (MultipartFile picture : files) {
                        String originalFilename = picture.getOriginalFilename();
                        //todo 这里可以改变文件名
                        //......
                        //写文件
                        String pathName = url + originalFilename;
                        picture.transferTo(new File(pathName));
                        imageUrls.add(pathName);
                    }
                }
            }
            //2.保存news
            NewsDetail newsDetail = newsService.addOrUpdateNews(request, imageUrls);

            return BaseResponse.ok(newsDetail);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

}
