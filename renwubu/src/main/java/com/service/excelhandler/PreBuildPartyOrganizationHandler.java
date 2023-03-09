package com.service.excelhandler;



import com.persistence.entity.PreBuildPartyOrganization;
import com.persistence.mapper.PreBuildPartyOrganizationMapper;
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
public class PreBuildPartyOrganizationHandler implements ExcelHandler {
    @Autowired
    private PreBuildPartyOrganizationMapper preBuildPartyOrganizationMapper;


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
        return "pre_build_party_organization.xml";
    }

    ;

    public void upload(MultipartFile file) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 3; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertPreBuildPartyOrganization(row);
        }

    }

    ;

    public void insertPreBuildPartyOrganization(Row row) {
        PreBuildPartyOrganization preBuildPartyOrganization = new PreBuildPartyOrganization();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        preBuildPartyOrganization.partyOrganizationName = commonService.getCellValueByCell(row.getCell(0));
        preBuildPartyOrganization.partyOrganizationStartTime = commonService.getCellValueByCell(row.getCell(1));
        preBuildPartyOrganization.approvalBy = commonService.getCellValueByCell(row.getCell(2));
        preBuildPartyOrganization.subordination = commonService.getCellValueByCell(row.getCell(3));
        preBuildPartyOrganization.team = commonService.getCellValueByCell(row.getCell(4));
        preBuildPartyOrganization.identity = commonService.getCellValueByCell(row.getCell(5));

        preBuildPartyOrganizationMapper.insert(preBuildPartyOrganization);

    }

    @Override
    public String download(String identity) throws IOException {
        List<PreBuildPartyOrganization> preBuildPartyOrganizationList = preBuildPartyOrganizationMapper.pageQuery("", "", identity, 0, 1000000);
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < preBuildPartyOrganizationList.size(); i++) {
            fillRows(preBuildPartyOrganizationList.get(i), sheet, i);
        }

        FileOutputStream fileOut = new FileOutputStream(url + "pre_build_party_organization.xls");
        wb.write(fileOut);
        fileOut.close();
        return mappingUrl + "pre_build_party_organization.xls";
    }

    private Workbook getWorkbook() throws IOException {
        FileInputStream inputStream = new FileInputStream(templateUrl + "pre_build_party_organization.xls");
        POIFSFileSystem fs = new POIFSFileSystem(inputStream);
        return new HSSFWorkbook(fs);
    }

    public void fillRows(PreBuildPartyOrganization preBuildPartyOrganization, Sheet sheet, int i) {
        int index = 3 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(preBuildPartyOrganization.partyOrganizationName);
        row.createCell(1).setCellValue(preBuildPartyOrganization.partyOrganizationStartTime);
        row.createCell(2).setCellValue(preBuildPartyOrganization.approvalBy);
        row.createCell(3).setCellValue(preBuildPartyOrganization.subordination);
        row.createCell(4).setCellValue(preBuildPartyOrganization.team);
        row.createCell(5).setCellValue(preBuildPartyOrganization.identity);

    }
}