package com.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author wuyuxiao
 */
@Data
public class NewsDetail {
    String newsGuid;
    String title;
    String text;
    String thirdMenuGuid;
    String deliverUserName;
    List<String> files;
}


