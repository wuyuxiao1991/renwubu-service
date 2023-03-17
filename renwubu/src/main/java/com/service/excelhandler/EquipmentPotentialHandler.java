package com.service.excelhandler;


import com.model.constants.enums.ExcelTypeEnum;
import com.model.request.UploadExcelRequest;
import com.persistence.entity.EquipmentPotentialRegistration;
import com.persistence.entity.PeoplePotentialRegistration;
import com.persistence.mapper.EquipmentPotentialMapper;
import com.persistence.mapper.PeoplePotentialMapper;
import com.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
public class EquipmentPotentialHandler implements ExcelHandler{
    @Autowired
    private EquipmentPotentialMapper mapper;


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
        return ExcelTypeEnum.EQUIPMENT_POTENTIAL.name();
    }

    ;

    @Override
    public void upload(MultipartFile file, UploadExcelRequest request) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 3; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertEquipmentPotentialRegistration(row,request.getIdentity());
        }

    }
    ;

    public void insertEquipmentPotentialRegistration(Row row, String identity){
        EquipmentPotentialRegistration equipmentPotentialRegistration = new EquipmentPotentialRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        equipmentPotentialRegistration.name = commonService.getCellValueByCell(row.getCell(0));
        equipmentPotentialRegistration.majorProperty = commonService.getCellValueByCell(row.getCell(1));
        equipmentPotentialRegistration.number = commonService.getCellValueByCell(row.getCell(2));
        equipmentPotentialRegistration.technicalStatus = commonService.getCellValueByCell(row.getCell(3));
        equipmentPotentialRegistration.storagePlace = commonService.getCellValueByCell(row.getCell(4));
        equipmentPotentialRegistration.keepOrganization = commonService.getCellValueByCell(row.getCell(5));
        equipmentPotentialRegistration.contactPerson = commonService.getCellValueByCell(row.getCell(6));
        equipmentPotentialRegistration.contactMethod = commonService.getCellValueByCell(row.getCell(7));
        equipmentPotentialRegistration.identity = identity;
        mapper.insert(equipmentPotentialRegistration);
    }

    @Override
    public String download(String identity) throws IOException, InvalidFormatException {
        List<EquipmentPotentialRegistration> equipmentPotentialRegistrations = mapper.pageQuery("",identity,0,1000000);
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i <equipmentPotentialRegistrations.size(); i++) {
            fillRows(equipmentPotentialRegistrations.get(i), sheet, i);
        }

        FileOutputStream fileOut = new FileOutputStream(url + "equipment_potential_registration.xlsx");
        wb.write(fileOut);
        fileOut.close();
        return mappingUrl + "equipment_potential_registration.xlsx";
    }

    private Workbook getWorkbook() throws IOException, InvalidFormatException {
        FileInputStream inputStream = new FileInputStream(templateUrl + "equipment_potential_registration.xlsx");
        OPCPackage pkg = OPCPackage.open(inputStream);
        return new XSSFWorkbook(pkg);
    }
    public void fillRows(EquipmentPotentialRegistration equipmentPotentialRegistration, Sheet sheet, int i) {
        int index = 3 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(equipmentPotentialRegistration.name);
        row.createCell(1).setCellValue(equipmentPotentialRegistration.majorProperty);
        row.createCell(2).setCellValue(equipmentPotentialRegistration.number);
        row.createCell(3).setCellValue(equipmentPotentialRegistration.technicalStatus);
        row.createCell(4).setCellValue(equipmentPotentialRegistration.storagePlace);
        row.createCell(5).setCellValue(equipmentPotentialRegistration.keepOrganization);
        row.createCell(6).setCellValue(equipmentPotentialRegistration.contactPerson);
        row.createCell(7).setCellValue(equipmentPotentialRegistration.contactMethod);

    }

}
