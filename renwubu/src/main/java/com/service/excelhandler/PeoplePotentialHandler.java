package com.service.excelhandler;


import com.model.constants.enums.ExcelTypeEnum;
import com.model.request.UploadExcelRequest;
import com.persistence.entity.PeoplePotentialRegistration;
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
public class PeoplePotentialHandler implements ExcelHandler{
    @Autowired
    private PeoplePotentialMapper mapper;


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
        return ExcelTypeEnum.PEOPLE_POTENTIAL.name();
    }

    ;

    @Override
    public void upload(MultipartFile file, UploadExcelRequest request) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 5; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertPeoplePotentialRegistration(row,request.getIdentity());
        }

    }
    ;

    public void insertPeoplePotentialRegistration(Row row, String identity){
        PeoplePotentialRegistration peoplePotentialRegistration = new PeoplePotentialRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        peoplePotentialRegistration.name = commonService.getCellValueByCell(row.getCell(1));
        peoplePotentialRegistration.idNumber = commonService.getCellValueByCell(row.getCell(2));
        peoplePotentialRegistration.sex = commonService.getCellValueByCell(row.getCell(3));
        peoplePotentialRegistration.politicalStatus = commonService.getCellValueByCell(row.getCell(4));
        peoplePotentialRegistration.joinPartyTime = commonService.getCellValueByCell(row.getCell(5));
        peoplePotentialRegistration.educationLevel = commonService.getCellValueByCell(row.getCell(6));
        peoplePotentialRegistration.nationality = commonService.getCellValueByCell(row.getCell(7));
        peoplePotentialRegistration.health = commonService.getCellValueByCell(row.getCell(8));
        peoplePotentialRegistration.work = commonService.getCellValueByCell(row.getCell(9));
        peoplePotentialRegistration.workProperty = commonService.getCellValueByCell(row.getCell(10));
        peoplePotentialRegistration.position = commonService.getCellValueByCell(row.getCell(11));
        peoplePotentialRegistration.isPartyWorker = commonService.getCellValueByCell(row.getCell(12));
        peoplePotentialRegistration.workPlace = commonService.getCellValueByCell(row.getCell(13));
        peoplePotentialRegistration.householdPlace = commonService.getCellValueByCell(row.getCell(14));
        peoplePotentialRegistration.phone = commonService.getCellValueByCell(row.getCell(15));
        peoplePotentialRegistration.militaryStatus = commonService.getCellValueByCell(row.getCell(16));
        peoplePotentialRegistration.isCollegeStudent = commonService.getCellValueByCell(row.getCell(17));
        peoplePotentialRegistration.enlistmentTime = commonService.getCellValueByCell(row.getCell(18));
        peoplePotentialRegistration.retireTime = commonService.getCellValueByCell(row.getCell(19));
        peoplePotentialRegistration.militaryServiceType = commonService.getCellValueByCell(row.getCell(20));
        peoplePotentialRegistration.militaryMajorName = commonService.getCellValueByCell(row.getCell(21));
        peoplePotentialRegistration.militaryMajorDuration = commonService.getCellValueByCell(row.getCell(22));
        peoplePotentialRegistration.positionWhenRetire = commonService.getCellValueByCell(row.getCell(23));
        peoplePotentialRegistration.rankWhenRetire = commonService.getCellValueByCell(row.getCell(24));
        peoplePotentialRegistration.localMajorName1 = commonService.getCellValueByCell(row.getCell(25));
        peoplePotentialRegistration.technicalTitle1 = commonService.getCellValueByCell(row.getCell(26));
        peoplePotentialRegistration.localMajorDuration1 = commonService.getCellValueByCell(row.getCell(27));
        peoplePotentialRegistration.localMajorName2 = commonService.getCellValueByCell(row.getCell(28));
        peoplePotentialRegistration.technicalTitle2 = commonService.getCellValueByCell(row.getCell(29));
        peoplePotentialRegistration.localMajorDuration2 = commonService.getCellValueByCell(row.getCell(30));
        peoplePotentialRegistration.identity = identity;
        mapper.insert(peoplePotentialRegistration);
    }

    @Override
    public String download(String identity) throws IOException, InvalidFormatException {
        List<PeoplePotentialRegistration> peoplePotentialRegistrations = mapper.pageQuery("",identity,0,1000000);
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i <peoplePotentialRegistrations.size(); i++) {
            fillRows(peoplePotentialRegistrations.get(i), sheet, i);
        }

        FileOutputStream fileOut = new FileOutputStream(url + "people_potential_registration.xlsx");
        wb.write(fileOut);
        fileOut.close();
        return mappingUrl + "people_potential_registration.xlsx";
    }

    private Workbook getWorkbook() throws IOException, InvalidFormatException {
        FileInputStream inputStream = new FileInputStream(templateUrl + "people_potential_registration.xlsx");
        OPCPackage pkg = OPCPackage.open(inputStream);
        return new XSSFWorkbook(pkg);
    }
    public void fillRows(PeoplePotentialRegistration peoplePotentialRegistration, Sheet sheet, int i) {
        int index = 5 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(peoplePotentialRegistration.id);
        row.createCell(1).setCellValue(peoplePotentialRegistration.name);
        row.createCell(2).setCellValue(peoplePotentialRegistration.idNumber);
        row.createCell(3).setCellValue(peoplePotentialRegistration.sex);
        row.createCell(4).setCellValue(peoplePotentialRegistration.politicalStatus);
        row.createCell(5).setCellValue(peoplePotentialRegistration.joinPartyTime);
        row.createCell(6).setCellValue(peoplePotentialRegistration.educationLevel);
        row.createCell(7).setCellValue(peoplePotentialRegistration.nationality);
        row.createCell(8).setCellValue(peoplePotentialRegistration.health);
        row.createCell(9).setCellValue(peoplePotentialRegistration.work);
        row.createCell(10).setCellValue(peoplePotentialRegistration.workProperty);
        row.createCell(11).setCellValue(peoplePotentialRegistration.position);
        row.createCell(12).setCellValue(peoplePotentialRegistration.isPartyWorker);
        row.createCell(13).setCellValue(peoplePotentialRegistration.workPlace);
        row.createCell(14).setCellValue(peoplePotentialRegistration.householdPlace);
        row.createCell(15).setCellValue(peoplePotentialRegistration.phone);
        row.createCell(16).setCellValue(peoplePotentialRegistration.militaryStatus);
        row.createCell(17).setCellValue(peoplePotentialRegistration.isCollegeStudent);
        row.createCell(18).setCellValue(peoplePotentialRegistration.enlistmentTime);
        row.createCell(19).setCellValue(peoplePotentialRegistration.retireTime);
        row.createCell(20).setCellValue(peoplePotentialRegistration.militaryServiceType);
        row.createCell(21).setCellValue(peoplePotentialRegistration.militaryMajorName);
        row.createCell(22).setCellValue(peoplePotentialRegistration.militaryMajorDuration);
        row.createCell(23).setCellValue(peoplePotentialRegistration.positionWhenRetire);
        row.createCell(24).setCellValue(peoplePotentialRegistration.rankWhenRetire);
        row.createCell(25).setCellValue(peoplePotentialRegistration.localMajorName1);
        row.createCell(26).setCellValue(peoplePotentialRegistration.technicalTitle1);
        row.createCell(27).setCellValue(peoplePotentialRegistration.localMajorDuration1);
        row.createCell(28).setCellValue(peoplePotentialRegistration.localMajorName2);
        row.createCell(29).setCellValue(peoplePotentialRegistration.technicalTitle2);
        row.createCell(30).setCellValue(peoplePotentialRegistration.localMajorDuration2);
    }

}
