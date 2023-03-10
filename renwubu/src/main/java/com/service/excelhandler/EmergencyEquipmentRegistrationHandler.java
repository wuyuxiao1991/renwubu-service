package com.service.excelhandler;


import com.persistence.entity.EmergencyEquipmentRegistration;
import com.persistence.mapper.EmergencyEquipmentRegistrationMapper;
import com.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j

public class EmergencyEquipmentRegistrationHandler implements ExcelHandler{

    @Autowired
    private EmergencyEquipmentRegistrationMapper emergencyEquipmentRegistrationMapper;


    @Autowired
    private CommonService commonService;

    @Value("${template.url}")
    private String templateUrl;

    @Value("${downloadExcel.url}")
    private String url;

    @Value("${downloadExcel.mappingUrl}")
    private String mappingUrl;


    @Override
    public String getExcelType(){return "emergency_equipment_registration.xml";};

    public void upload(MultipartFile file,String identity){
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 6; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertEmergencyEquipmentRegistration(row);
        }

    };

    public void insertEmergencyEquipmentRegistration(Row row){
        EmergencyEquipmentRegistration emergencyEquipmentRegistration =new EmergencyEquipmentRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()){
            return;
        }
        emergencyEquipmentRegistration.equipmentName = commonService.getCellValueByCell(row.getCell(0));
        emergencyEquipmentRegistration.type = commonService.getCellValueByCell(row.getCell(1));
        emergencyEquipmentRegistration.unit = commonService.getCellValueByCell(row.getCell(2));
        emergencyEquipmentRegistration.number = commonService.getCellValueByCell(row.getCell(3));
        emergencyEquipmentRegistration.use = commonService.getCellValueByCell(row.getCell(4));
        emergencyEquipmentRegistration.warehousingTime = commonService.getCellValueByCell(row.createCell(5));
        emergencyEquipmentRegistration.equipmentPerformance = commonService.getCellValueByCell(row.createCell(6));
        emergencyEquipmentRegistration.storagePlace = commonService.getCellValueByCell(row.createCell(7));
        emergencyEquipmentRegistration.managementUnit = commonService.getCellValueByCell(row.createCell(8));
        emergencyEquipmentRegistration.dispatchTime = commonService.getCellValueByCell(row.getCell(9));
        emergencyEquipmentRegistration.organizationType = commonService.getCellValueByCell(row.createCell(10));
        emergencyEquipmentRegistration.district = commonService.getCellValueByCell(row.getCell(11));
        emergencyEquipmentRegistration.identity = commonService.getCellValueByCell(row.createCell(12));


        emergencyEquipmentRegistrationMapper.insert(emergencyEquipmentRegistration);

    }

    @Override
    public String download(String identity) throws IOException {
        List<EmergencyEquipmentRegistration> emergencyEquipmentRegistrationHandlerList = emergencyEquipmentRegistrationMapper.pageQuery("","",identity,0,1000000);
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i <emergencyEquipmentRegistrationHandlerList.size(); i++) {
            fillRows(emergencyEquipmentRegistrationHandlerList.get(i), sheet, i);
        }

        FileOutputStream fileOut = new FileOutputStream(url + "emergency_equipment_registration.xls");
        wb.write(fileOut);
        fileOut.close();
        return mappingUrl + "emergency_equipment_registration.xls";
    }

    private Workbook getWorkbook() throws IOException {
        FileInputStream inputStream = new FileInputStream(templateUrl + "emergency_equipment_registration.xls");
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    public void fillRows(EmergencyEquipmentRegistration emergencyEquipmentRegistration,Sheet sheet,int i){
        int index=6+i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(emergencyEquipmentRegistration.id);
        row.createCell(1).setCellValue(emergencyEquipmentRegistration.equipmentName);
        row.createCell(2).setCellValue(emergencyEquipmentRegistration.type);
        row.createCell(3).setCellValue(emergencyEquipmentRegistration.unit);
        row.createCell(4).setCellValue(emergencyEquipmentRegistration.number);
        row.createCell(5).setCellValue(emergencyEquipmentRegistration.use);
        row.createCell(6).setCellValue(emergencyEquipmentRegistration.warehousingTime);
        row.createCell(7).setCellValue(emergencyEquipmentRegistration.equipmentName);
        row.createCell(8).setCellValue(emergencyEquipmentRegistration.storagePlace);
        row.createCell(9).setCellValue(emergencyEquipmentRegistration.managementUnit);
        row.createCell(10).setCellValue(emergencyEquipmentRegistration.dispatchTime);
        row.createCell(11).setCellValue(emergencyEquipmentRegistration.organizationType);
        row.createCell(12).setCellValue(emergencyEquipmentRegistration.identity);
    }



}
