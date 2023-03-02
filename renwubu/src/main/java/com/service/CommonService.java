package com.service;


import com.model.request.DeleteItemRequest;
import com.persistence.mapper.CommonMapper;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * @author wuyuxiao
 */
@Service
public class CommonService {
    @Autowired
    private CommonMapper commonMapper;

    public void deleteItem(DeleteItemRequest request) {
        commonMapper.deleteItem(request.getId(), request.getTableName());
    }


    public Workbook getWorkbook(MultipartFile file) { //根据excel文件的后缀名来获取对应的工作簿
        Workbook workbook = null;
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.') + 1);
        InputStream in = null;
        try {
            in = file.getInputStream();
            if ("xls".equals(suffix)) {
                workbook = new HSSFWorkbook(in);
            } else if ("xlsx".equals(suffix)) {
                workbook = new XSSFWorkbook(in);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }


    public String getCellValueByCell(Cell cell) { //判断单元格中数据的类型，并以字符串形式返回
        //判断是否为null或空串
        if (cell == null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {  //判断日期类型
                    cellValue = new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
                } else {  //否
                    cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                }
                break;
            case STRING:
                cellValue = cell.getStringCellValue().trim();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            default:
                cellValue = "";
                break;
        }
        return cellValue;
    }




}