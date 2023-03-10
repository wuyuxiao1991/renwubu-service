package com.service.excelhandler;
import com.persistence.entity.MilitaryAndCivilianEquipmentRegistration;
import com.persistence.mapper.MilitaryCivilizationEquipmentMapper;
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
public class MilitaryAndCivilianEquipmentRegistrationHandler implements ExcelHandler {
    @Autowired
    private MilitaryCivilizationEquipmentMapper militaryCivilizationEquipmentMapper;


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
        return "emergency_equipment_registration.xml";
    }

    ;

    public void upload(MultipartFile file,String identity) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 6; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertMilitaryAndCivilianEquipmentRegistration(row);
        }

    }

    ;

    public void insertMilitaryAndCivilianEquipmentRegistration(Row row) {
        MilitaryAndCivilianEquipmentRegistration militaryAndCivilianEquipmentRegistration = new MilitaryAndCivilianEquipmentRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        militaryAndCivilianEquipmentRegistration.equipmentName = commonService.getCellValueByCell(row.getCell(0));
        militaryAndCivilianEquipmentRegistration.type = commonService.getCellValueByCell(row.getCell(1));
        militaryAndCivilianEquipmentRegistration.unit = commonService.getCellValueByCell(row.getCell(2));
        militaryAndCivilianEquipmentRegistration.number = commonService.getCellValueByCell(row.getCell(3));
        militaryAndCivilianEquipmentRegistration.use = commonService.getCellValueByCell(row.getCell(4));
        militaryAndCivilianEquipmentRegistration.warehousingTime = commonService.getCellValueByCell(row.getCell(5));
        militaryAndCivilianEquipmentRegistration.equipmentPerformance = commonService.getCellValueByCell(row.getCell(6));
        militaryAndCivilianEquipmentRegistration.storagePlace = commonService.getCellValueByCell(row.getCell(7));
        militaryAndCivilianEquipmentRegistration.managementUnit = commonService.getCellValueByCell(row.getCell(8));
        militaryAndCivilianEquipmentRegistration.dispatchTime = commonService.getCellValueByCell(row.getCell(9));
        militaryAndCivilianEquipmentRegistration.organizationType = commonService.getCellValueByCell(row.getCell(10));
        militaryAndCivilianEquipmentRegistration.identity = commonService.getCellValueByCell(row.getCell(11));
        militaryCivilizationEquipmentMapper.insert(militaryAndCivilianEquipmentRegistration);
    }

    @Override
    public String download(String identity) throws IOException {
        List<MilitaryAndCivilianEquipmentRegistration> militaryAndCivilianEquipmentRegistrationList = militaryCivilizationEquipmentMapper.pageQuery("", "", identity, 0, 1000000);
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < militaryAndCivilianEquipmentRegistrationList.size(); i++) {
            fillRows(militaryAndCivilianEquipmentRegistrationList.get(i), sheet, i);
        }

        FileOutputStream fileOut = new FileOutputStream(url + "military_and_civilian_equipment_registration.xls");
        wb.write(fileOut);
        fileOut.close();
        return mappingUrl + "military_and_civilian_equipment_registration.xls";
    }

    private Workbook getWorkbook() throws IOException {
        FileInputStream inputStream = new FileInputStream(templateUrl + "military_and_civilian_equipment_registration.xls");
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    public void fillRows(MilitaryAndCivilianEquipmentRegistration militaryAndCivilianEquipmentRegistration, Sheet sheet, int i) {
        int index = 6 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(militaryAndCivilianEquipmentRegistration.equipmentName);
        row.createCell(1).setCellValue(militaryAndCivilianEquipmentRegistration.type);
        row.createCell(2).setCellValue(militaryAndCivilianEquipmentRegistration.unit);
        row.createCell(3).setCellValue(militaryAndCivilianEquipmentRegistration.number);
        row.createCell(4).setCellValue(militaryAndCivilianEquipmentRegistration.use);
        row.createCell(5).setCellValue(militaryAndCivilianEquipmentRegistration.warehousingTime);
        row.createCell(6).setCellValue(militaryAndCivilianEquipmentRegistration.equipmentPerformance);
        row.createCell(7).setCellValue(militaryAndCivilianEquipmentRegistration.storagePlace);
        row.createCell(8).setCellValue(militaryAndCivilianEquipmentRegistration.managementUnit);
        row.createCell(9).setCellValue(militaryAndCivilianEquipmentRegistration.dispatchTime);
        row.createCell(10).setCellValue(militaryAndCivilianEquipmentRegistration.organizationType);
        row.createCell(11).setCellValue(militaryAndCivilianEquipmentRegistration.identity);

    }
}