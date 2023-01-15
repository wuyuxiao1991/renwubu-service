package com.renwubu.model.dto;

/**
 * @author wuyuxiao
 */
public class SubmenuNewsDto {
    String submenu;
    NewsContent content;

    public SubmenuNewsDto(String submenu, NewsContent content) {
        this.submenu = submenu;
        this.content = content;
    }


}