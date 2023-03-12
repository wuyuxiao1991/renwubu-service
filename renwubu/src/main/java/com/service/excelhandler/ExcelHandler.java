package com.service.excelhandler;


import com.model.request.UploadExcelRequest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author wuyuxiao
 */
public interface ExcelHandler {
    public String getExcelType();

    public void upload(MultipartFile file, UploadExcelRequest request);

    public String download(String identity) throws IOException, InvalidFormatException;

}