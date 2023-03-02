package com.endpoint;

import com.model.BaseResponse;
import com.model.dto.NewsDetail;
import com.model.dto.NewsDto;
import com.model.request.*;
import com.service.NewsService;
import com.service.ThirdMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class NewsController {
    @Autowired
    private ThirdMenuService thirdMenuService;

    @Autowired
    private NewsService newsService;

    @Value("${image.url}")
    private String url;

    @PostMapping("/page_query_news")
    public BaseResponse<PageQueryNewsResponse> pageQueryNews(@RequestBody PageQueryNewsRequest request) {
        try {

            List<NewsDto> newsList = newsService.pageQueryNews(request.getThirdMenuGuid(),
                    request.getSearchKey(), request.getPageNumber(), request.getPageSize());

            int count = newsService.queryNewsTotalCount(request.getThirdMenuGuid(),
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
            if (files != null) {
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

    @PostMapping("/upload_images")
    public BaseResponse<List<String>> uploadImages(@RequestPart(value = "images", required = false) MultipartFile[] files) {
        try {
            List<String> imageUrls = new ArrayList<>();
            if (files != null) {
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

            return BaseResponse.ok(imageUrls);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }

}
