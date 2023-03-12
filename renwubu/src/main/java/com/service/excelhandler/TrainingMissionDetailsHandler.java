package com.service.excelhandler;

import com.model.constants.enums.ExcelTypeEnum;
import com.model.request.UploadExcelRequest;
import com.persistence.entity.TrainingMissionDetails;
import com.persistence.mapper.TrainingMissionDetailMapper;
import com.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
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
 * @author wuyuxiao
 */
@Service
@Slf4j

public class TrainingMissionDetailsHandler implements ExcelHandler {
    @Autowired
    private TrainingMissionDetailMapper trainingMissionDetailMapper;

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
        return ExcelTypeEnum.TRAINING_MISSION_DETAILS.name();
    }

    @Override
    public void upload(MultipartFile file, UploadExcelRequest request) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 3; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertTrainingMissionDetails(row, request.getIdentity(),request.getYear());
        }
    }

    @Override
    public String download(String identity) throws IOException, InvalidFormatException {
        //1.查出列表数据
        List<TrainingMissionDetails> list = trainingMissionDetailMapper.pageQuery("", "", "", "", "", identity, 0, 1000000000);

        //2.填充workbook
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < list.size(); i++) {
            fillRows(list.get(i), sheet, i);
        }

        //3.写入新文件
        String downloadFilePath = url + "training_mission_details.xlsx";
        FileOutputStream fileOut = new FileOutputStream(downloadFilePath);
        wb.write(fileOut);
        fileOut.close();

        return mappingUrl + "training_mission_details.xlsx";
    }

    private void insertTrainingMissionDetails(Row row, String identity, String year) {
        TrainingMissionDetails trainingMissionDetails = new TrainingMissionDetails();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        trainingMissionDetails.year = year;
        trainingMissionDetails.teamBranchName = commonService.getCellValueByCell(row.getCell(1));
        trainingMissionDetails.affiliation = commonService.getCellValueByCell(row.getCell(2));
        trainingMissionDetails.teamType = commonService.getCellValueByCell(row.getCell(3));
        trainingMissionDetails.organizedHeadcount = commonService.getCellValueByCell(row.getCell(4));
        trainingMissionDetails.trainingHeadcount = commonService.getCellValueByCell(row.getCell(5));
        trainingMissionDetails.baseConcentratedTrainingTime = commonService.getCellValueByCell(row.getCell(6));
        trainingMissionDetails.otherTraningTime = commonService.getCellValueByCell(row.getCell(7));
        trainingMissionDetails.totalCount = commonService.getCellValueByCell(row.getCell(8));
        trainingMissionDetails.concentratedTrainingPlace = commonService.getCellValueByCell(row.getCell(9));
        trainingMissionDetails.identity = identity;

        //todo 判重 击中了就continue
        trainingMissionDetailMapper.insert(trainingMissionDetails);
    }

    private Workbook getWorkbook() throws IOException, InvalidFormatException {
        String peopleDetailTemplatePath = templateUrl + "training_mission_details.xlsx";
        FileInputStream inputStream = new FileInputStream(peopleDetailTemplatePath);
        OPCPackage pkg = OPCPackage.open(inputStream);
        return new XSSFWorkbook(pkg);
    }

    private void fillRows(TrainingMissionDetails trainingMissionDetails, Sheet sheet, int i) {
        int index = 3 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(trainingMissionDetails.id);
        row.createCell(1).setCellValue(trainingMissionDetails.teamBranchName);
        row.createCell(2).setCellValue(trainingMissionDetails.affiliation);
        row.createCell(3).setCellValue(trainingMissionDetails.teamType);
        row.createCell(4).setCellValue(trainingMissionDetails.organizedHeadcount);
        row.createCell(5).setCellValue(trainingMissionDetails.trainingHeadcount);
        row.createCell(6).setCellValue(trainingMissionDetails.baseConcentratedTrainingTime);
        row.createCell(7).setCellValue(trainingMissionDetails.otherTraningTime);
        row.createCell(8).setCellValue(trainingMissionDetails.totalCount);
        row.createCell(9).setCellValue(trainingMissionDetails.concentratedTrainingPlace);
    }
}


