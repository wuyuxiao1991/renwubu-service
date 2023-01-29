package com.endpoint;

import com.model.BaseResponse;
import com.model.dto.NewsDetail;
import com.model.dto.NewsDto;
import com.model.request.AddOrUpdateRequest;
import com.model.request.DeleteNewsRequest;
import com.model.request.PageQueryNewsRequest;
import com.model.request.QueryNewsDetailRequest;
import com.persistence.entity.Menu;
import com.persistence.entity.Submenu;
import com.service.MenuService;
import com.service.NewsService;
import com.service.SubmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

    @PostMapping("/page_query_news")
    public BaseResponse<List<NewsDto>> pageQueryNews(@RequestBody PageQueryNewsRequest request) {
        try {
            //1.根据菜单名找到母菜单
            Menu menu = menuService.getMenus(request.getMenuName(), request.getIdentity());

            //2.根据母菜单找到子菜单
            List<Submenu> submenuList = submenuService.getSubmenusByMenuGuid(menu.menuGuid);

            //3.分页查询news
            List<NewsDto> newsList = newsService.pageQueryNews(submenuList.stream().map(p -> p.submenuGuid).collect(Collectors.toList()),
                    request.getSearchKey(), request.getPageNumber(), request.getPageSize());
            return BaseResponse.ok(newsList);
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
    public BaseResponse<NewsDetail> addOrUpdateNews(@RequestPart(value = "images", required = true) MultipartFile[] files, @RequestPart("content") AddOrUpdateRequest request) {
        try {
//            1.上传图片到tomcat路径下
            long count = Arrays.stream(files)
                    .map(MultipartFile::getOriginalFilename).filter(Objects::nonNull).count();
            List<String> imageUrls = new ArrayList<>();
            if (count > 0) {
                for (MultipartFile picture : files) {
                    String originalFilename = picture.getOriginalFilename();
                    //todo 这里可以改变文件名
                    //......
                    //写文件
                    String pathName = "G:/apache-tomcat-9.0.71/apache-tomcat-9.0.71/webapps/images" + "/" + originalFilename;
                    picture.transferTo(new File(pathName));
                    imageUrls.add(pathName);
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
