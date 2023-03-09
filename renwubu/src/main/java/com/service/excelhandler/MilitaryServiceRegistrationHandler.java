package com.service.excelhandler;




import com.persistence.entity.MilitaryServiceRegistration;
import com.persistence.mapper.MilitaryServiceRegistrationMapper;
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
public class MilitaryServiceRegistrationHandler implements ExcelHandler{
    @Autowired
    private MilitaryServiceRegistrationMapper militaryServiceRegistrationMapper;


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
        return "military_service_registration.xml";
    }

    ;

    public void upload(MultipartFile file) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertMilitaryServiceRegistration(row);
        }

    }
    ;

    public void insertMilitaryServiceRegistration(Row row){
        MilitaryServiceRegistration militaryServiceRegistration = new MilitaryServiceRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        militaryServiceRegistration.idNumber = commonService.getCellValueByCell(row.getCell(1));
        militaryServiceRegistration.name = commonService.getCellValueByCell(row.getCell(2));
        militaryServiceRegistration.sex = commonService.getCellValueByCell(row.getCell(3));
        militaryServiceRegistration.birthDate = commonService.getCellValueByCell(row.getCell(4));
        militaryServiceRegistration.householdPlace = commonService.getCellValueByCell(row.getCell(5));
        militaryServiceRegistration.workPlace = commonService.getCellValueByCell(row.getCell(6));
        militaryServiceRegistration.receiptConfirmation = commonService.getCellValueByCell(row.getCell(7));
        militaryServiceRegistration.status = commonService.getCellValueByCell(row.getCell(8));
        militaryServiceRegistration.identity = commonService.getCellValueByCell(row.getCell(9));
    }

    @Override
    public String download(String identity) throws IOException {
        List<MilitaryServiceRegistration> militaryServiceRegistrationList = militaryServiceRegistrationMapper.pageQuery("","","",identity,0,1000000);
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 1; i <militaryServiceRegistrationList.size(); i++) {
            fillRows(militaryServiceRegistrationList.get(i), sheet, i);
        }

        FileOutputStream fileOut = new FileOutputStream(url + "military_service_registration.xls");
        wb.write(fileOut);
        fileOut.close();
        return mappingUrl + "military_service_registration.xls";
    }

    private Workbook getWorkbook() throws IOException {
        FileInputStream inputStream = new FileInputStream(templateUrl + "military_service_registration.xls");
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }
    public void fillRows(MilitaryServiceRegistration militaryServiceRegistration, Sheet sheet, int i) {
        int index = 1 + i;
        Row row = sheet.createRow(index);
        row.createCell(1).setCellValue(militaryServiceRegistration.idNumber);
        row.createCell(2).setCellValue(militaryServiceRegistration.sex);
        row.createCell(3).setCellValue(militaryServiceRegistration.sex);
        row.createCell(4).setCellValue(militaryServiceRegistration.birthDate);
        row.createCell(5).setCellValue(militaryServiceRegistration.householdPlace);
        row.createCell(6).setCellValue(militaryServiceRegistration.workPlace);
        row.createCell(7).setCellValue(militaryServiceRegistration.receiptConfirmation);
        row.createCell(8).setCellValue(militaryServiceRegistration.status);
        row.createCell(9).setCellValue(militaryServiceRegistration.identity);
    }

}
