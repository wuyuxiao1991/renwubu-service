package com.service.excelhandler;

import com.persistence.entity.ZhuanwuLeaderRegistration;
import com.persistence.mapper.ZhuanwuLeaderRegistrationMapper;
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
public class ZhuanwuLeaderRegistrationHandler implements ExcelHandler{
    @Autowired
    private ZhuanwuLeaderRegistrationMapper zhuanwuLeaderRegistrationMapper;

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
        return "zhuanwu_leader_registration";
    }

    @Override
    public void upload(MultipartFile file, String identity) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 4; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertZhuanwuLeaderRegistration(row, identity);
        }
    }

    @Override
    public String download(String identity) throws IOException {
        //1.查出列表数据
        List<ZhuanwuLeaderRegistration> list = zhuanwuLeaderRegistrationMapper.pageQuery("","","","","","","",0,100000000);
        //2.填充workbook
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < list.size(); i++) {
            fillRows(list.get(i), sheet, i);
        }

        //3.写入新文件
        String downloadFilePath = url + "zhuanwu_leader_registration.xls";
        FileOutputStream fileOut = new FileOutputStream(downloadFilePath);
        wb.write(fileOut);
        fileOut.close();

        return mappingUrl + "zhuanwu_leader_registration.xls";
    }


    private void insertZhuanwuLeaderRegistration(Row row, String identity) {
        ZhuanwuLeaderRegistration zhuanwuLeaderRegistration = new ZhuanwuLeaderRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        zhuanwuLeaderRegistration.work = commonService.getCellValueByCell(row.getCell(1));
        zhuanwuLeaderRegistration.position = commonService.getCellValueByCell(row.getCell(2));
        zhuanwuLeaderRegistration.name = commonService.getCellValueByCell(row.getCell(3));
        zhuanwuLeaderRegistration.sex = commonService.getCellValueByCell(row.getCell(4));
        zhuanwuLeaderRegistration.idNumber = commonService.getCellValueByCell(row.getCell(5));
        zhuanwuLeaderRegistration.politicalStatus = commonService.getCellValueByCell(row.getCell(6));
        zhuanwuLeaderRegistration.educationLevel = commonService.getCellValueByCell(row.getCell(7));
        zhuanwuLeaderRegistration.phone = commonService.getCellValueByCell(row.getCell(8));
        zhuanwuLeaderRegistration.birthDate = commonService.getCellValueByCell(row.getCell(9));
        zhuanwuLeaderRegistration.partyTime = commonService.getCellValueByCell(row.getCell(10));
        zhuanwuLeaderRegistration.workDuration = commonService.getCellValueByCell(row.getCell(11));
        zhuanwuLeaderRegistration.mianrenUnit = commonService.getCellValueByCell(row.getCell(12));
        zhuanwuLeaderRegistration.isInMinbing = commonService.getCellValueByCell(row.getCell(13));
        zhuanwuLeaderRegistration.teamNameAndPosition = commonService.getCellValueByCell(row.getCell(14));
        zhuanwuLeaderRegistration.partyWorkTime = commonService.getCellValueByCell(row.getCell(15));
        zhuanwuLeaderRegistration.isRetireMilitary = commonService.getCellValueByCell(row.getCell(16));
        zhuanwuLeaderRegistration.enlistmentTime = commonService.getCellValueByCell(row.getCell(17));
        zhuanwuLeaderRegistration.retireTime = commonService.getCellValueByCell(row.getCell(18));
        zhuanwuLeaderRegistration.durationOfMilitary= commonService.getCellValueByCell(row.getCell(19));
        zhuanwuLeaderRegistration.typeOfMilitaryService = commonService.getCellValueByCell(row.getCell(20));
        zhuanwuLeaderRegistration.positionWhenRetire = commonService.getCellValueByCell(row.getCell(21));
        zhuanwuLeaderRegistration.isTrainedInRenwuSchool = commonService.getCellValueByCell(row.getCell(22));
        zhuanwuLeaderRegistration.isPass = commonService.getCellValueByCell(row.getCell(23));
        zhuanwuLeaderRegistration.qualificationTimeAndUnit = commonService.getCellValueByCell(row.getCell(24));
        zhuanwuLeaderRegistration.trainingSituation = commonService.getCellValueByCell(row.getCell(25));
        zhuanwuLeaderRegistration.testResult = commonService.getCellValueByCell(row.getCell(26));
        zhuanwuLeaderRegistration.taskExecution = commonService.getCellValueByCell(row.getCell(27));
        zhuanwuLeaderRegistration.rewardAndPunishment = commonService.getCellValueByCell(row.getCell(28));
        zhuanwuLeaderRegistration.resume = commonService.getCellValueByCell(row.getCell(29));
        zhuanwuLeaderRegistration.parttimeNumber = commonService.getCellValueByCell(row.getCell(30));
        zhuanwuLeaderRegistration.parttimeWork = commonService.getCellValueByCell(row.getCell(31));
        zhuanwuLeaderRegistration.identity = identity;

        //todo 判重 击中了就continue
        zhuanwuLeaderRegistrationMapper.insert(zhuanwuLeaderRegistration);
    }

    private Workbook getWorkbook() throws IOException {
        String peopleDetailTemplatePath = templateUrl + "zhuanwu_leader_registration.xls";
        FileInputStream inputStream = new FileInputStream(peopleDetailTemplatePath);
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    private void fillRows(ZhuanwuLeaderRegistration zhuanwuLeaderRegistration, Sheet sheet, int i) {
        int index = 4 + i;
        Row row = sheet.createRow(index);
        row.createCell(1).setCellValue(zhuanwuLeaderRegistration.work);
        row.createCell(2).setCellValue(zhuanwuLeaderRegistration.position);
        row.createCell(3).setCellValue(zhuanwuLeaderRegistration.name);
        row.createCell(4).setCellValue(zhuanwuLeaderRegistration.sex);
        row.createCell(5).setCellValue(zhuanwuLeaderRegistration.idNumber);
        row.createCell(6).setCellValue(zhuanwuLeaderRegistration.politicalStatus);
        row.createCell(7).setCellValue(zhuanwuLeaderRegistration.educationLevel);
        row.createCell(8).setCellValue(zhuanwuLeaderRegistration.phone);
        row.createCell(9).setCellValue(zhuanwuLeaderRegistration.birthDate);
        row.createCell(10).setCellValue(zhuanwuLeaderRegistration.partyTime);
        row.createCell(11).setCellValue(zhuanwuLeaderRegistration.workDuration);
        row.createCell(12).setCellValue(zhuanwuLeaderRegistration.mianrenUnit);
        row.createCell(13).setCellValue(zhuanwuLeaderRegistration.isInMinbing);
        row.createCell(14).setCellValue(zhuanwuLeaderRegistration.teamNameAndPosition);
        row.createCell(15).setCellValue(zhuanwuLeaderRegistration.partyWorkTime);
        row.createCell(16).setCellValue(zhuanwuLeaderRegistration.isRetireMilitary);
        row.createCell(17).setCellValue(zhuanwuLeaderRegistration.enlistmentTime);
        row.createCell(18).setCellValue(zhuanwuLeaderRegistration.retireTime);
        row.createCell(19).setCellValue(zhuanwuLeaderRegistration.durationOfMilitary);
        row.createCell(20).setCellValue(zhuanwuLeaderRegistration.typeOfMilitaryService);
        row.createCell(21).setCellValue(zhuanwuLeaderRegistration.positionWhenRetire);
        row.createCell(22).setCellValue(zhuanwuLeaderRegistration.isTrainedInRenwuSchool);
        row.createCell(23).setCellValue(zhuanwuLeaderRegistration.isPass);
        row.createCell(24).setCellValue(zhuanwuLeaderRegistration.qualificationTimeAndUnit);
        row.createCell(25).setCellValue(zhuanwuLeaderRegistration.trainingSituation);
        row.createCell(26).setCellValue(zhuanwuLeaderRegistration.testResult);
        row.createCell(27).setCellValue(zhuanwuLeaderRegistration.taskExecution);
        row.createCell(28).setCellValue(zhuanwuLeaderRegistration.rewardAndPunishment);
        row.createCell(29).setCellValue(zhuanwuLeaderRegistration.resume);
        row.createCell(30).setCellValue(zhuanwuLeaderRegistration.parttimeNumber);
        row.createCell(31).setCellValue(zhuanwuLeaderRegistration.parttimeWork);

    }
}

