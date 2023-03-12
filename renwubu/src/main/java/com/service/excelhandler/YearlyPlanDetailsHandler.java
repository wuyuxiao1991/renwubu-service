package com.service.excelhandler;

import com.model.constants.enums.ExcelTypeEnum;
import com.model.request.UploadExcelRequest;
import com.persistence.entity.YearlyPlanDetails;
import com.persistence.mapper.YearlyPlanDetailsMapper;
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
public class YearlyPlanDetailsHandler implements ExcelHandler {
    @Autowired
    private YearlyPlanDetailsMapper yearlyPlanDetailsMapper;

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
        return ExcelTypeEnum.YEARLY_PLAN_DETAILS.name();
    }

    @Override
    public void upload(MultipartFile file, UploadExcelRequest request) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 3; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertYearlyPlanDetails(row, request.getIdentity(), request.getYear());
        }
    }

    @Override
    public String download(String identity) throws IOException {
        //1.查出列表数据
        List<YearlyPlanDetails> list = yearlyPlanDetailsMapper.pageQuery("", "", "", "", 0, 10000000);

        //2.填充workbook
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < list.size(); i++) {
            fillRows(list.get(i), sheet, i);
        }

        //3.写入新文件
        String downloadFilePath = url + "yearly_plan_details.xls";
        FileOutputStream fileOut = new FileOutputStream(downloadFilePath);
        wb.write(fileOut);
        fileOut.close();

        return mappingUrl + "yearly_plan_details.xls";
    }


    private void insertYearlyPlanDetails(Row row, String identity, String year) {
        YearlyPlanDetails yearlyPlanDetails = new YearlyPlanDetails();
        if (commonService.getCellValueByCell(row.getCell(0)).isEmpty()) {
            return;
        }
        yearlyPlanDetails.year = year;
        yearlyPlanDetails.affiliation = commonService.getCellValueByCell(row.getCell(0));
        yearlyPlanDetails.month = commonService.getCellValueByCell(row.getCell(1));
        yearlyPlanDetails.teamBranch = commonService.getCellValueByCell(row.getCell(2));
        yearlyPlanDetails.teamType = commonService.getCellValueByCell(row.getCell(3));
        yearlyPlanDetails.isTaskTeam = commonService.getCellValueByCell(row.getCell(4));
        yearlyPlanDetails.organizedHeadcount = commonService.getCellValueByCell(row.getCell(5));
        yearlyPlanDetails.trainingHeadcount = commonService.getCellValueByCell(row.getCell(6));
        yearlyPlanDetails.baseConcentratedTrainingTime = commonService.getCellValueByCell(row.getCell(7));
        yearlyPlanDetails.otherTraningTime = commonService.getCellValueByCell(row.getCell(8));
        yearlyPlanDetails.totalCount = commonService.getCellValueByCell(row.getCell(9));
        yearlyPlanDetails.concentratedTrainingPlace = commonService.getCellValueByCell(row.getCell(10));
        yearlyPlanDetails.identity = identity;

        //todo 判重 击中了就continue
        yearlyPlanDetailsMapper.insert(yearlyPlanDetails);
    }

    private Workbook getWorkbook() throws IOException {
        String peopleDetailTemplatePath = templateUrl + "yearly_plan_details.xls";
        FileInputStream inputStream = new FileInputStream(peopleDetailTemplatePath);
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    private void fillRows(YearlyPlanDetails yearlyPlanDetails, Sheet sheet, int i) {
        int index = 3 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(yearlyPlanDetails.affiliation);
        row.createCell(1).setCellValue(yearlyPlanDetails.month);
        row.createCell(2).setCellValue(yearlyPlanDetails.teamBranch);
        row.createCell(3).setCellValue(yearlyPlanDetails.teamType);
        row.createCell(4).setCellValue(yearlyPlanDetails.isTaskTeam);
        row.createCell(5).setCellValue(yearlyPlanDetails.organizedHeadcount);
        row.createCell(6).setCellValue(yearlyPlanDetails.trainingHeadcount);
        row.createCell(7).setCellValue(yearlyPlanDetails.baseConcentratedTrainingTime);
        row.createCell(8).setCellValue(yearlyPlanDetails.otherTraningTime);
        row.createCell(9).setCellValue(yearlyPlanDetails.totalCount);
        row.createCell(10).setCellValue(yearlyPlanDetails.concentratedTrainingPlace);

    }
}

