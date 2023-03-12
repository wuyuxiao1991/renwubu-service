package com.service.excelhandler;

import com.model.constants.enums.ExcelTypeEnum;
import com.model.request.UploadExcelRequest;
import com.persistence.entity.MinbingLeaderRegistration;
import com.persistence.mapper.MinbingLeaderRegistrationMapper;
import com.service.CommonService;
import com.service.excelhandler.ExcelHandler;
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
public class MinbingLeaderRegistrationHandler implements ExcelHandler {
    @Autowired
    private MinbingLeaderRegistrationMapper minbingLeaderRegistrationMapper;

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
        return ExcelTypeEnum.MINBING_LEADER_REGISTRATION.name();
    }

    @Override
    public void upload(MultipartFile file, UploadExcelRequest request) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 4; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertMinbingLeaderRegistration(row, request.getIdentity());
        }
    }

    @Override
    public String download(String identity) throws IOException {
        //1.查出列表数据
        List<MinbingLeaderRegistration> list = minbingLeaderRegistrationMapper.pageQuery("","","","","","",identity,0,1000000000);

        //2.填充workbook
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < list.size(); i++) {
            fillRows(list.get(i), sheet, i);
        }

        //3.写入新文件
        String downloadFilePath = url + "minbing_leader_registration.xls";
        FileOutputStream fileOut = new FileOutputStream(downloadFilePath);
        wb.write(fileOut);
        fileOut.close();

        return mappingUrl + "minbing_leader_registration.xls";
    }


    private void insertMinbingLeaderRegistration(Row row, String identity) {
        MinbingLeaderRegistration minbingLeaderRegistration = new MinbingLeaderRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        minbingLeaderRegistration.work = commonService.getCellValueByCell(row.getCell(1));
        minbingLeaderRegistration.position = commonService.getCellValueByCell(row.getCell(2));
        minbingLeaderRegistration.name= commonService.getCellValueByCell(row.getCell(3));
        minbingLeaderRegistration.sex = commonService.getCellValueByCell(row.getCell(4));
        minbingLeaderRegistration.idNumber = commonService.getCellValueByCell(row.getCell(5));
        minbingLeaderRegistration.politicalStatus = commonService.getCellValueByCell(row.getCell(6));
        minbingLeaderRegistration.educationLevel = commonService.getCellValueByCell(row.getCell(7));
        minbingLeaderRegistration.phone = commonService.getCellValueByCell(row.getCell(8));
        minbingLeaderRegistration.birthDate = commonService.getCellValueByCell(row.getCell(9));
        minbingLeaderRegistration.partyTime= commonService.getCellValueByCell(row.getCell(10));
        minbingLeaderRegistration.workDuration = commonService.getCellValueByCell(row.getCell(11));
        minbingLeaderRegistration.mianrenUnit = commonService.getCellValueByCell(row.getCell(12));
        minbingLeaderRegistration.isInMinbing = commonService.getCellValueByCell(row.getCell(13));
        minbingLeaderRegistration.teamNameAndPosition = commonService.getCellValueByCell(row.getCell(14));
        minbingLeaderRegistration.partyWorkTime = commonService.getCellValueByCell(row.getCell(15));
        minbingLeaderRegistration.isRetireMilitary = commonService.getCellValueByCell(row.getCell(16));
        minbingLeaderRegistration.enlistmentTime = commonService.getCellValueByCell(row.getCell(17));
        minbingLeaderRegistration.retireTime = commonService.getCellValueByCell(row.getCell(18));
        minbingLeaderRegistration.durationOfMilitary = commonService.getCellValueByCell(row.getCell(19));
        minbingLeaderRegistration.typeOfMilitaryService = commonService.getCellValueByCell(row.getCell(20));
        minbingLeaderRegistration.positionWhenRetire = commonService.getCellValueByCell(row.getCell(21));
        minbingLeaderRegistration.isTrainedInRenwuSchool = commonService.getCellValueByCell(row.getCell(22));
        minbingLeaderRegistration.isPass = commonService.getCellValueByCell(row.getCell(23));
        minbingLeaderRegistration.qualificationTimeAndUnit = commonService.getCellValueByCell(row.getCell(24));
        minbingLeaderRegistration.trainingSituation = commonService.getCellValueByCell(row.getCell(25));
        minbingLeaderRegistration.testResult = commonService.getCellValueByCell(row.getCell(26));
        minbingLeaderRegistration.taskExecution = commonService.getCellValueByCell(row.getCell(27));
        minbingLeaderRegistration.rewardAndPunishment = commonService.getCellValueByCell(row.getCell(28));
        minbingLeaderRegistration.resume = commonService.getCellValueByCell(row.getCell(29));
        minbingLeaderRegistration.parttimeNumber = commonService.getCellValueByCell(row.getCell(30));
        minbingLeaderRegistration.parttimeWork = commonService.getCellValueByCell(row.getCell(31));
        minbingLeaderRegistration.identity = identity;

        //todo 判重 击中了就continue
        minbingLeaderRegistrationMapper.insert(minbingLeaderRegistration);
    }

    private Workbook getWorkbook() throws IOException {
        String peopleDetailTemplatePath = templateUrl + "minbing_leader_registration.xls";
        FileInputStream inputStream = new FileInputStream(peopleDetailTemplatePath);
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    private void fillRows(MinbingLeaderRegistration minbingLeaderRegistration, Sheet sheet, int i) {
        int index = 4 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(minbingLeaderRegistration.id);
        row.createCell(1).setCellValue(minbingLeaderRegistration.work);
        row.createCell(2).setCellValue(minbingLeaderRegistration.position);
        row.createCell(3).setCellValue(minbingLeaderRegistration.name);
        row.createCell(4).setCellValue(minbingLeaderRegistration.sex);
        row.createCell(5).setCellValue(minbingLeaderRegistration.idNumber);
        row.createCell(6).setCellValue(minbingLeaderRegistration.politicalStatus);
        row.createCell(7).setCellValue(minbingLeaderRegistration.educationLevel);
        row.createCell(8).setCellValue(minbingLeaderRegistration.phone);
        row.createCell(9).setCellValue(minbingLeaderRegistration.birthDate);
        row.createCell(10).setCellValue(minbingLeaderRegistration.partyTime);
        row.createCell(11).setCellValue(minbingLeaderRegistration.workDuration);
        row.createCell(12).setCellValue(minbingLeaderRegistration.mianrenUnit);
        row.createCell(13).setCellValue(minbingLeaderRegistration.isInMinbing);
        row.createCell(14).setCellValue(minbingLeaderRegistration.teamNameAndPosition);
        row.createCell(15).setCellValue(minbingLeaderRegistration.partyWorkTime);
        row.createCell(16).setCellValue(minbingLeaderRegistration.isRetireMilitary);
        row.createCell(17).setCellValue(minbingLeaderRegistration.enlistmentTime);
        row.createCell(18).setCellValue(minbingLeaderRegistration.retireTime);
        row.createCell(19).setCellValue(minbingLeaderRegistration.durationOfMilitary);
        row.createCell(20).setCellValue(minbingLeaderRegistration.typeOfMilitaryService);
        row.createCell(21).setCellValue(minbingLeaderRegistration.positionWhenRetire);
        row.createCell(22).setCellValue(minbingLeaderRegistration.isTrainedInRenwuSchool);
        row.createCell(23).setCellValue(minbingLeaderRegistration.isPass);
        row.createCell(24).setCellValue(minbingLeaderRegistration.qualificationTimeAndUnit);
        row.createCell(25).setCellValue(minbingLeaderRegistration.trainingSituation);
        row.createCell(26).setCellValue(minbingLeaderRegistration.testResult);
        row.createCell(27).setCellValue(minbingLeaderRegistration.taskExecution);
        row.createCell(28).setCellValue(minbingLeaderRegistration.rewardAndPunishment);
        row.createCell(29).setCellValue(minbingLeaderRegistration.resume);
        row.createCell(30).setCellValue(minbingLeaderRegistration.parttimeNumber);
        row.createCell(31).setCellValue(minbingLeaderRegistration.parttimeWork);
    }
}

