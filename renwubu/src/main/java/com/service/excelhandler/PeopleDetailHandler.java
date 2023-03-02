package com.service.excelhandler;


import com.persistence.entity.PeopleDetail;
import com.persistence.mapper.PeopleDetailMapper;
import com.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;

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

    @Override
    public  String getExcelType() {
        return "people_detail";
    }

    @Override
    public void upload(MultipartFile file) {
        try {
            Workbook workbook = commonService.getWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getPhysicalNumberOfRows();
            for (int i = 5; i < rowNum; i++) {
                Row row = sheet.getRow(i);
                PeopleDetail peopleDetail = new PeopleDetail();
                if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
                    break;
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
                peopleDetail.identity = commonService.getCellValueByCell(row.getCell(34));
                //判重 击中了就continue
                peopleDetailMapper.insert(peopleDetail);
            }
        }finally {
            log.info("insert people detail list");
        }
    }
}