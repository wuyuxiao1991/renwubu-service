package com.service.excelhandler;


import com.persistence.entity.PeopleDetail;
import com.persistence.mapper.PeopleDetailMapper;
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
public class PeopleDetailHandler implements ExcelHandler {
    @Autowired
    private PeopleDetailMapper peopleDetailMapper;

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
        return "people_detail";
    }

    @Override
    public void upload(MultipartFile file, String identity) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 5; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertPeopleDetail(row, identity);
        }
    }

    @Override
    public String download(String identity) throws IOException {
        //1.查出列表数据
        List<PeopleDetail> peopleDetailList = peopleDetailMapper.pageQuery("", "", "", "", identity, 0, 100000000);

        //2.填充workbook
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < peopleDetailList.size(); i++) {
            fillRows(peopleDetailList.get(i), sheet, i);
        }

        //3.写入新文件
        String downloadFilePath = url + "people_detail.xls";
        FileOutputStream fileOut = new FileOutputStream(downloadFilePath);
        wb.write(fileOut);
        fileOut.close();

        return mappingUrl + "people_detail.xls";
    }


    private void insertPeopleDetail(Row row, String identity) {
        PeopleDetail peopleDetail = new PeopleDetail();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        peopleDetail.name = commonService.getCellValueByCell(row.getCell(1));
        peopleDetail.nationality = commonService.getCellValueByCell(row.getCell(2));
        peopleDetail.idNumber = commonService.getCellValueByCell(row.getCell(3));
        peopleDetail.sex = commonService.getCellValueByCell(row.getCell(4));
        peopleDetail.politicalStatus = commonService.getCellValueByCell(row.getCell(5));
        peopleDetail.educationLevel = commonService.getCellValueByCell(row.getCell(6));
        peopleDetail.nationality = commonService.getCellValueByCell(row.getCell(7));
        peopleDetail.health = commonService.getCellValueByCell(row.getCell(8));
        peopleDetail.work = commonService.getCellValueByCell(row.getCell(9));
        peopleDetail.workType = commonService.getCellValueByCell(row.getCell(10));
        peopleDetail.position = commonService.getCellValueByCell(row.getCell(11));
        peopleDetail.isGovernmentWorker = commonService.getCellValueByCell(row.getCell(12));
        peopleDetail.workPlace = commonService.getCellValueByCell(row.getCell(13));
        peopleDetail.householdPlace = commonService.getCellValueByCell(row.getCell(14));
        peopleDetail.phone = commonService.getCellValueByCell(row.getCell(15));
        peopleDetail.militaryServiceStatus = commonService.getCellValueByCell(row.getCell(16));
        peopleDetail.isStudentInCollege = commonService.getCellValueByCell(row.getCell(17));
        peopleDetail.enlistmentTime = commonService.getCellValueByCell(row.getCell(18));
        peopleDetail.retireTime = commonService.getCellValueByCell(row.getCell(19));
        peopleDetail.typeOfMilitary = commonService.getCellValueByCell(row.getCell(20));
        peopleDetail.militaryMajorName = commonService.getCellValueByCell(row.getCell(21));
        peopleDetail.militaryMajorDuration = commonService.getCellValueByCell(row.getCell(22));
        peopleDetail.positionWhenRetire = commonService.getCellValueByCell(row.getCell(23));
        peopleDetail.militaryRankWhenRetire = commonService.getCellValueByCell(row.getCell(24));
        peopleDetail.localProfessionType1 = commonService.getCellValueByCell(row.getCell(25));
        peopleDetail.localProfessionName1 = commonService.getCellValueByCell(row.getCell(26));
        peopleDetail.technicalTitle1 = commonService.getCellValueByCell(row.getCell(27));
        peopleDetail.professionDuration1 = commonService.getCellValueByCell(row.getCell(28));
        peopleDetail.localProfessionType2 = commonService.getCellValueByCell(row.getCell(29));
        peopleDetail.localProfessionName2 = commonService.getCellValueByCell(row.getCell(30));
        peopleDetail.technicalTitle2 = commonService.getCellValueByCell(row.getCell(31));
        peopleDetail.professionDuration2 = commonService.getCellValueByCell(row.getCell(32));
        peopleDetail.direction = commonService.getCellValueByCell(row.getCell(33));
        peopleDetail.identity = identity;
        //判重 击中了就continue
        peopleDetailMapper.insert(peopleDetail);
    }

    private Workbook getWorkbook() throws IOException {
        String peopleDetailTemplatePath = templateUrl + "people_detail.xls";
        FileInputStream inputStream = new FileInputStream(peopleDetailTemplatePath);
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    private void fillRows(PeopleDetail peopleDetail, Sheet sheet, int i) {
        int index = 5 + i;
        Row row = sheet.createRow(index);
        row.createCell(1).setCellValue(peopleDetail.name);
        row.createCell(2).setCellValue(peopleDetail.rank);
        row.createCell(3).setCellValue(peopleDetail.idNumber);
        row.createCell(4).setCellValue(peopleDetail.sex);
        row.createCell(5).setCellValue(peopleDetail.politicalStatus);
        row.createCell(6).setCellValue(peopleDetail.educationLevel);
        row.createCell(7).setCellValue(peopleDetail.nationality);
        row.createCell(8).setCellValue(peopleDetail.health);
        row.createCell(9).setCellValue(peopleDetail.work);
        row.createCell(10).setCellValue(peopleDetail.workType);
        row.createCell(11).setCellValue(peopleDetail.position);
        row.createCell(12).setCellValue(peopleDetail.isGovernmentWorker);
        row.createCell(13).setCellValue(peopleDetail.workPlace);
        row.createCell(14).setCellValue(peopleDetail.householdPlace);
        row.createCell(15).setCellValue(peopleDetail.phone);
        row.createCell(16).setCellValue(peopleDetail.militaryServiceStatus);
        row.createCell(17).setCellValue(peopleDetail.isStudentInCollege);
        row.createCell(18).setCellValue(peopleDetail.enlistmentTime);
        row.createCell(19).setCellValue(peopleDetail.retireTime);
        row.createCell(20).setCellValue(peopleDetail.typeOfMilitary);
        row.createCell(21).setCellValue(peopleDetail.militaryMajorName);
        row.createCell(22).setCellValue(peopleDetail.militaryMajorDuration);
        row.createCell(23).setCellValue(peopleDetail.positionWhenRetire);
        row.createCell(24).setCellValue(peopleDetail.militaryRankWhenRetire);
        row.createCell(25).setCellValue(peopleDetail.localProfessionType1);
        row.createCell(26).setCellValue(peopleDetail.localProfessionName1);
        row.createCell(27).setCellValue(peopleDetail.technicalTitle1);
        row.createCell(28).setCellValue(peopleDetail.professionDuration1);
        row.createCell(29).setCellValue(peopleDetail.localProfessionType2);
        row.createCell(30).setCellValue(peopleDetail.localProfessionName2);
        row.createCell(31).setCellValue(peopleDetail.technicalTitle2);
        row.createCell(32).setCellValue(peopleDetail.professionDuration2);
        row.createCell(33).setCellValue(peopleDetail.direction);
    }
}

