package com.service.excelhandler;


import com.persistence.entity.ArmsEquipmentRegistration;
import com.persistence.mapper.ArmsEquipmentRegistrationMapper;
import com.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
@Slf4j
public class ArmsEquipmentRegistrationHandler implements ExcelHandler {
    @Autowired
    private ArmsEquipmentRegistrationMapper mapper;

    @Autowired
    private CommonService commonService;

    @Value("${template.url}")
    private String templateUrl;

    @Value("${downloadExcel.url}")
    private String url;

    @Value("${downloadExcel.mappingUrl}")
    private String mappingUrl;


    @Override
    public String getExcelType() {
        return "arms_equipment_registration";
    }

    @Override
    public void upload(MultipartFile file, String identity) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 6; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertArmsEquipmentRegistration(row, identity);
        }
    }

    @Override
    public String download(String identity) throws IOException {
        //1.查出列表数据
        List<ArmsEquipmentRegistration> list = mapper.pageQuery("", "", identity, 0, 100000000);

        //2.填充workbook
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < list.size(); i++) {
            fillRows(list.get(i), sheet, i);
        }

        //3.写入新文件
        String downloadFilePath = url + "arms_equipment_registration.xls";
        FileOutputStream fileOut = new FileOutputStream(downloadFilePath);
        wb.write(fileOut);
        fileOut.close();

        return mappingUrl + "arms_equipment_registration.xls";
    }


    private void insertArmsEquipmentRegistration(Row row, String identity) {
        ArmsEquipmentRegistration armsEquipmentRegistration = new ArmsEquipmentRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        armsEquipmentRegistration.equipmentName = commonService.getCellValueByCell(row.getCell(0));
        armsEquipmentRegistration.type = commonService.getCellValueByCell(row.getCell(1));
        armsEquipmentRegistration.unit = commonService.getCellValueByCell(row.getCell(2));
        armsEquipmentRegistration.number = commonService.getCellValueByCell(row.getCell(3));
        armsEquipmentRegistration.qualityLevel = commonService.getCellValueByCell(row.getCell(4));
        armsEquipmentRegistration.usage = commonService.getCellValueByCell(row.getCell(5));
        armsEquipmentRegistration.warehousingTime = commonService.getCellValueByCell(row.getCell(6));
        armsEquipmentRegistration.equipmentPerformance = commonService.getCellValueByCell(row.getCell(7));
        armsEquipmentRegistration.storagePlace = commonService.getCellValueByCell(row.getCell(8));
        armsEquipmentRegistration.managementUnit = commonService.getCellValueByCell(row.getCell(9));
        armsEquipmentRegistration.dispatchTime = commonService.getCellValueByCell(row.getCell(10));
        armsEquipmentRegistration.organizationType = commonService.getCellValueByCell(row.getCell(11));
        armsEquipmentRegistration.district = commonService.getCellValueByCell(row.getCell(12));
        armsEquipmentRegistration.identity = identity;

        //todo 判重 击中了就continue
        mapper.insert(armsEquipmentRegistration);
    }

    private Workbook getWorkbook() throws IOException {
        String peopleDetailTemplatePath = templateUrl + "arms_equipment_registration.xls";
        FileInputStream inputStream = new FileInputStream(peopleDetailTemplatePath);
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    private void fillRows(ArmsEquipmentRegistration armsEquipmentRegistration, Sheet sheet, int i) {
        int index = 6 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(armsEquipmentRegistration.equipmentName);
        row.createCell(1).setCellValue(armsEquipmentRegistration.type);
        row.createCell(2).setCellValue(armsEquipmentRegistration.unit);
        row.createCell(3).setCellValue(armsEquipmentRegistration.number);
        row.createCell(4).setCellValue(armsEquipmentRegistration.qualityLevel);
        row.createCell(5).setCellValue(armsEquipmentRegistration.usage);
        row.createCell(6).setCellValue(armsEquipmentRegistration.warehousingTime);
        row.createCell(7).setCellValue(armsEquipmentRegistration.equipmentPerformance);
        row.createCell(8).setCellValue(armsEquipmentRegistration.storagePlace);
        row.createCell(9).setCellValue(armsEquipmentRegistration.managementUnit);
        row.createCell(10).setCellValue(armsEquipmentRegistration.dispatchTime);
        row.createCell(11).setCellValue(armsEquipmentRegistration.organizationType);
        row.createCell(12).setCellValue(armsEquipmentRegistration.district);
    }
}

