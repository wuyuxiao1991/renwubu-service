package com.service.excelhandler;


import com.model.constants.enums.ExcelTypeEnum;
import com.model.request.UploadExcelRequest;
import com.persistence.entity.CompanyPotentialRegistration;
import com.persistence.entity.EquipmentPotentialRegistration;
import com.persistence.mapper.CompanyPotentialMapper;
import com.persistence.mapper.EquipmentPotentialMapper;
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

/**
 * @author wuyuxiao1991
 */
@Service
@Slf4j
public class CompanyPotentialHandler implements ExcelHandler{
    @Autowired
    private CompanyPotentialMapper mapper;


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
        return ExcelTypeEnum.COMPANY_POTENTIAL.name();
    }

    ;

    @Override
    public void upload(MultipartFile file, UploadExcelRequest request) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 4; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertEquipmentPotentialRegistration(row,request.getIdentity());
        }

    }
    ;

    public void insertEquipmentPotentialRegistration(Row row, String identity){
        CompanyPotentialRegistration companyPotentialRegistration = new CompanyPotentialRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        companyPotentialRegistration.name = commonService.getCellValueByCell(row.getCell(0));
        companyPotentialRegistration.uniqueCode = commonService.getCellValueByCell(row.getCell(1));
        companyPotentialRegistration.workPlace = commonService.getCellValueByCell(row.getCell(2));
        companyPotentialRegistration.workDetailedAddress = commonService.getCellValueByCell(row.getCell(3));
        companyPotentialRegistration.contactPerson = commonService.getCellValueByCell(row.getCell(4));
        companyPotentialRegistration.contactMethod = commonService.getCellValueByCell(row.getCell(5));
        companyPotentialRegistration.property = commonService.getCellValueByCell(row.getCell(6));
        companyPotentialRegistration.industry = commonService.getCellValueByCell(row.getCell(7));
        companyPotentialRegistration.partyOrganizationBuilding = commonService.getCellValueByCell(row.getCell(8));
        companyPotentialRegistration.business = commonService.getCellValueByCell(row.getCell(9));
        companyPotentialRegistration.maleEmployeeNumber = commonService.getCellValueByCell(row.getCell(10));
        companyPotentialRegistration.femaleEmployeeNumber = commonService.getCellValueByCell(row.getCell(11));
        companyPotentialRegistration.majorBusiness = commonService.getCellValueByCell(row.getCell(12));
        companyPotentialRegistration.equipmentName = commonService.getCellValueByCell(row.getCell(13));
        companyPotentialRegistration.equipmentMajorProperty = commonService.getCellValueByCell(row.getCell(14));
        companyPotentialRegistration.equipmentNumber = commonService.getCellValueByCell(row.getCell(15));
        companyPotentialRegistration.professionalDirection = commonService.getCellValueByCell(row.getCell(16));
        companyPotentialRegistration.professionalPeopleCount = commonService.getCellValueByCell(row.getCell(17));
        companyPotentialRegistration.hasBusinessArmedForce = commonService.getCellValueByCell(row.getCell(18));
        companyPotentialRegistration.identity = identity;
        mapper.insert(companyPotentialRegistration);
    }

    @Override
    public String download(String identity) throws IOException, InvalidFormatException {
        List<CompanyPotentialRegistration> companyPotentialRegistrations = mapper.pageQuery("",identity,0,1000000);
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i <companyPotentialRegistrations.size(); i++) {
            fillRows(companyPotentialRegistrations.get(i), sheet, i);
        }

        FileOutputStream fileOut = new FileOutputStream(url + "company_potential_registration.xlsx");
        wb.write(fileOut);
        fileOut.close();
        return mappingUrl + "company_potential_registration.xlsx";
    }

    private Workbook getWorkbook() throws IOException, InvalidFormatException {
        FileInputStream inputStream = new FileInputStream(templateUrl + "company_potential_registration.xlsx");
        OPCPackage pkg = OPCPackage.open(inputStream);
        return new XSSFWorkbook(pkg);
    }
    public void fillRows(CompanyPotentialRegistration companyPotentialRegistration, Sheet sheet, int i) {
        int index = 4 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(companyPotentialRegistration.name);
        row.createCell(1).setCellValue(companyPotentialRegistration.uniqueCode);
        row.createCell(2).setCellValue(companyPotentialRegistration.workPlace);
        row.createCell(3).setCellValue(companyPotentialRegistration.workDetailedAddress);
        row.createCell(4).setCellValue(companyPotentialRegistration.contactPerson);
        row.createCell(5).setCellValue(companyPotentialRegistration.contactMethod);
        row.createCell(6).setCellValue(companyPotentialRegistration.property);
        row.createCell(7).setCellValue(companyPotentialRegistration.industry);
        row.createCell(8).setCellValue(companyPotentialRegistration.partyOrganizationBuilding);
        row.createCell(9).setCellValue(companyPotentialRegistration.business);
        row.createCell(10).setCellValue(companyPotentialRegistration.maleEmployeeNumber);
        row.createCell(11).setCellValue(companyPotentialRegistration.femaleEmployeeNumber);
        row.createCell(12).setCellValue(companyPotentialRegistration.majorBusiness);
        row.createCell(13).setCellValue(companyPotentialRegistration.equipmentName);
        row.createCell(14).setCellValue(companyPotentialRegistration.equipmentMajorProperty);
        row.createCell(15).setCellValue(companyPotentialRegistration.equipmentNumber);
        row.createCell(16).setCellValue(companyPotentialRegistration.professionalDirection);
        row.createCell(17).setCellValue(companyPotentialRegistration.professionalPeopleCount);
        row.createCell(18).setCellValue(companyPotentialRegistration.hasBusinessArmedForce);
    }

}
