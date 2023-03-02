package com.service.excelhandler;


import org.springframework.web.multipart.MultipartFile;

/**
 * @author wuyuxiao
 */
public interface ExcelHandler {
    public String getExcelType();

    public void upload(MultipartFile file);
}