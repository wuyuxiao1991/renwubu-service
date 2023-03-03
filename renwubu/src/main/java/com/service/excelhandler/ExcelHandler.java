package com.service.excelhandler;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author wuyuxiao
 */
public interface ExcelHandler {
    public String getExcelType();

    public void upload(MultipartFile file);

    public String download(String identity) throws IOException;

}