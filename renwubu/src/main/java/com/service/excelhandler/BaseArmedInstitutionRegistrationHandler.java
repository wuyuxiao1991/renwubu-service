package com.service.excelhandler;

import com.persistence.entity.BaseArmedInstitutionRegistration;
import com.persistence.mapper.BaseArmedInstitutionRegistrationMapper;
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

public class BaseArmedInstitutionRegistrationHandler implements  ExcelHandler {


    @Autowired
    private BaseArmedInstitutionRegistrationMapper baseArmedInstitutionRegistrationMapper;


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
        return "base_armed_institution_registration.xml";
    }

    ;

    public void upload(MultipartFile file) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 4; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertBaseArmedInstitutionRegistration(row);
        }

    }

    ;

    public void insertBaseArmedInstitutionRegistration(Row row) {
        BaseArmedInstitutionRegistration baseArmedInstitutionRegistration = new BaseArmedInstitutionRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        baseArmedInstitutionRegistration.name = commonService.getCellValueByCell(row.getCell(1));
        baseArmedInstitutionRegistration.type = commonService.getCellValueByCell(row.getCell(2));
        baseArmedInstitutionRegistration.place = commonService.getCellValueByCell(row.getCell(3));
        baseArmedInstitutionRegistration.approvalBy = commonService.getCellValueByCell(row.getCell(4));
        baseArmedInstitutionRegistration.managementRelation = commonService.getCellValueByCell(row.getCell(5));
        baseArmedInstitutionRegistration.level = commonService.getCellValueByCell(row.getCell(6));
        baseArmedInstitutionRegistration.regionDistribution = commonService.getCellValueByCell(row.getCell(7));
        baseArmedInstitutionRegistration.memo = commonService.getCellValueByCell(row.getCell(8));
        baseArmedInstitutionRegistration.identity = commonService.getCellValueByCell(row.getCell(9));
        baseArmedInstitutionRegistrationMapper.insert(baseArmedInstitutionRegistration);
    }

    public String download(String identity) throws IOException {
        List<BaseArmedInstitutionRegistration> baseArmedInstitutionRegistrationList = baseArmedInstitutionRegistrationMapper.pageQuery("", "", identity, "", "", "", "", "", identity, 0, 1000000);
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 1; i < baseArmedInstitutionRegistrationList.size(); i++) {
            fillRows(baseArmedInstitutionRegistrationList.get(i), sheet, i);
        }
        FileOutputStream fileOut = new FileOutputStream(url + "base_armed_institution_registration.xls");
        wb.write(fileOut);
        fileOut.close();
        return mappingUrl + "base_armed_institution_registration.xls";
    }

    private Workbook getWorkbook() throws IOException {
        FileInputStream inputStream = new FileInputStream(templateUrl + "base_armed_institution_registration.xls");
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    public void fillRows(BaseArmedInstitutionRegistration baseArmedInstitutionRegistration, Sheet sheet, int i) {
        int index = 4 + i;
        Row row = sheet.createRow(index);
        row.createCell(1).setCellValue(baseArmedInstitutionRegistration.name);
        row.createCell(2).setCellValue(baseArmedInstitutionRegistration.type);
        row.createCell(3).setCellValue(baseArmedInstitutionRegistration.place);
        row.createCell(4).setCellValue(baseArmedInstitutionRegistration.approvalBy);
        row.createCell(5).setCellValue(baseArmedInstitutionRegistration.managementRelation);
        row.createCell(6).setCellValue(baseArmedInstitutionRegistration.level);
        row.createCell(7).setCellValue(baseArmedInstitutionRegistration.regionDistribution);
        row.createCell(8).setCellValue(baseArmedInstitutionRegistration.memo);
        row.createCell(9).setCellValue(baseArmedInstitutionRegistration.identity);


    }
}