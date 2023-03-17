package com.service.excelhandler;


import com.model.constants.enums.ExcelTypeEnum;
import com.model.request.UploadExcelRequest;
import com.persistence.entity.EmergencyEquipmentRegistration;
import com.persistence.mapper.EmergencyEquipmentRegistrationMapper;
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
    public String getExcelType(){return ExcelTypeEnum.EMERGENCY_EQUIPMENT_REGISTRATION.name();};

    @Override
    public void upload(MultipartFile file, UploadExcelRequest request){
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 6; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertEmergencyEquipmentRegistration(row,request.getIdentity());
        }

    };

    public void insertEmergencyEquipmentRegistration(Row row,String identity){
        EmergencyEquipmentRegistration emergencyEquipmentRegistration =new EmergencyEquipmentRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()){
            return;
        }
        emergencyEquipmentRegistration.equipmentName = commonService.getCellValueByCell(row.getCell(0));
        emergencyEquipmentRegistration.type = commonService.getCellValueByCell(row.getCell(1));
        emergencyEquipmentRegistration.unit = commonService.getCellValueByCell(row.getCell(2));
        emergencyEquipmentRegistration.number = commonService.getCellValueByCell(row.getCell(3));
        emergencyEquipmentRegistration.purpose = commonService.getCellValueByCell(row.getCell(4));
        emergencyEquipmentRegistration.warehousingTime = commonService.getCellValueByCell(row.createCell(5));
        emergencyEquipmentRegistration.equipmentPerformance = commonService.getCellValueByCell(row.createCell(6));
        emergencyEquipmentRegistration.storagePlace = commonService.getCellValueByCell(row.createCell(7));
        emergencyEquipmentRegistration.managementUnit = commonService.getCellValueByCell(row.createCell(8));
        emergencyEquipmentRegistration.dispatchTime = commonService.getCellValueByCell(row.getCell(9));
        emergencyEquipmentRegistration.organizationType = commonService.getCellValueByCell(row.getCell(10));
        emergencyEquipmentRegistration.identity = identity;

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
        row.createCell(0).setCellValue(emergencyEquipmentRegistration.equipmentName);
        row.createCell(1).setCellValue(emergencyEquipmentRegistration.type);
        row.createCell(2).setCellValue(emergencyEquipmentRegistration.unit);
        row.createCell(3).setCellValue(emergencyEquipmentRegistration.number);
        row.createCell(4).setCellValue(emergencyEquipmentRegistration.purpose);
        row.createCell(5).setCellValue(emergencyEquipmentRegistration.warehousingTime);
        row.createCell(6).setCellValue(emergencyEquipmentRegistration.equipmentName);
        row.createCell(7).setCellValue(emergencyEquipmentRegistration.storagePlace);
        row.createCell(8).setCellValue(emergencyEquipmentRegistration.managementUnit);
        row.createCell(9).setCellValue(emergencyEquipmentRegistration.dispatchTime);
        row.createCell(10).setCellValue(emergencyEquipmentRegistration.organizationType);
    }



}
