package com.service.excelhandler;

import com.model.constants.enums.ExcelTypeEnum;
import com.model.request.UploadExcelRequest;
import com.persistence.entity.MilitaryStrengthRegistration;
import com.persistence.mapper.MilitaryStrengthRegistrationMapper;
import com.service.CommonService;
import com.service.excelhandler.ExcelHandler;
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
public class MilitaryStrengthRegistrationHandler implements ExcelHandler {
    @Autowired
    private MilitaryStrengthRegistrationMapper militaryStrengthRegistrationMapper;

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
        return ExcelTypeEnum.MILITARY_STRENGTH_REGISTRATION.name();
    }

    @Override
    public void upload(MultipartFile file, UploadExcelRequest request) {
        Workbook workbook = commonService.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 8; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            insertMilitaryStrengthRegistration(row, request.getIdentity());
        }
    }

    @Override
    public String download(String identity) throws IOException, InvalidFormatException {
        //1.查出列表数据
        List<MilitaryStrengthRegistration> list = militaryStrengthRegistrationMapper.pageQuery("","", "","",identity,0,10000000);

        //2.填充workbook
        Workbook wb = getWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < list.size(); i++) {
            fillRows(list.get(i), sheet, i);
        }

        //3.写入新文件
        String downloadFilePath = url + "military_strength_registration.xls";
        FileOutputStream fileOut = new FileOutputStream(downloadFilePath);
        wb.write(fileOut);
        fileOut.close();

        return mappingUrl + "military_strength_registration.xls";
    }


    private void insertMilitaryStrengthRegistration(Row row, String identity) {
        MilitaryStrengthRegistration militaryStrengthRegistration = new MilitaryStrengthRegistration();
        if (commonService.getCellValueByCell(row.getCell(1)).isEmpty()) {
            return;
        }
        militaryStrengthRegistration.requiredBy = commonService.getCellValueByCell(row.getCell(1));
        militaryStrengthRegistration.taskType = commonService.getCellValueByCell(row.getCell(2));
        militaryStrengthRegistration.startToEndTime = commonService.getCellValueByCell(row.getCell(3));
        militaryStrengthRegistration.concreteTask = commonService.getCellValueByCell(row.getCell(4));
        militaryStrengthRegistration.requirementNumber = commonService.getCellValueByCell(row.getCell(5));
        militaryStrengthRegistration.taskPlace = commonService.getCellValueByCell(row.getCell(6));
        militaryStrengthRegistration.approvalBy = commonService.getCellValueByCell(row.getCell(7));
        militaryStrengthRegistration.approvalFileName = commonService.getCellValueByCell(row.getCell(8));
        militaryStrengthRegistration.issuedNumber = commonService.getCellValueByCell(row.getCell(9));
        militaryStrengthRegistration.commandUnit = commonService.getCellValueByCell(row.getCell(10));
        militaryStrengthRegistration.commandInfo = commonService.getCellValueByCell(row.getCell(11));
        militaryStrengthRegistration.fundsSource = commonService.getCellValueByCell(row.getCell(12));
        militaryStrengthRegistration.subsidyStandard = commonService.getCellValueByCell(row.getCell(13));
        militaryStrengthRegistration.equipmentRequirement = commonService.getCellValueByCell(row.getCell(14));
        militaryStrengthRegistration.totalPeopleForLooseUse = commonService.getCellValueByCell(row.getCell(15));
        militaryStrengthRegistration.totalPeopleDayForLooseUse = commonService.getCellValueByCell(row.getCell(16));
        militaryStrengthRegistration.normalPeopleForLooseUse = commonService.getCellValueByCell(row.getCell(17));
        militaryStrengthRegistration.normalPeopleDayForLooseUse = commonService.getCellValueByCell(row.getCell(18));
        militaryStrengthRegistration.jiganPeopleForLooseUse = commonService.getCellValueByCell(row.getCell(19));
        militaryStrengthRegistration.jiganPeopleDayForLooseUse = commonService.getCellValueByCell(row.getCell(20));
        militaryStrengthRegistration.newPowerPeopleForLooseUse = commonService.getCellValueByCell(row.getCell(21));
        militaryStrengthRegistration.newPowerPeopleDayForLooseUse = commonService.getCellValueByCell(row.getCell(22));
        militaryStrengthRegistration.totalTeamForSystemUse = commonService.getCellValueByCell(row.getCell(23));
        militaryStrengthRegistration.totalPeopleForSystemUse = commonService.getCellValueByCell(row.getCell(24));
        militaryStrengthRegistration.totalPeopleDayForSystemUse = commonService.getCellValueByCell(row.getCell(25));
        militaryStrengthRegistration.normalMinbingTeamNameForSystemUse = commonService.getCellValueByCell(row.getCell(26));
        militaryStrengthRegistration.normalMinbingPeopleForSystemUse = commonService.getCellValueByCell(row.getCell(27));
        militaryStrengthRegistration.normalMinbingPeopleDayForSystemUse = commonService.getCellValueByCell(row.getCell(28));
        militaryStrengthRegistration.jiganMinbingTeamNameForSystemUse = commonService.getCellValueByCell(row.getCell(29));
        militaryStrengthRegistration.jiganMinbingPeopleForSystemUse = commonService.getCellValueByCell(row.getCell(30));
        militaryStrengthRegistration.jiganMinbingPeopleDayForSystemUse = commonService.getCellValueByCell(row.getCell(31));
        militaryStrengthRegistration.newPowerPeopleForSystemUse = commonService.getCellValueByCell(row.getCell(32));
        militaryStrengthRegistration.newPowerPeopleDayForSystemUse = commonService.getCellValueByCell(row.getCell(33));
        militaryStrengthRegistration.totalDisptachEquipment = commonService.getCellValueByCell(row.getCell(34));
        militaryStrengthRegistration.lightWeapon = commonService.getCellValueByCell(row.getCell(35));
        militaryStrengthRegistration.observationEquipment = commonService.getCellValueByCell(row.getCell(36));
        militaryStrengthRegistration.communicationEquipment = commonService.getCellValueByCell(row.getCell(37));
        militaryStrengthRegistration.carEquipment = commonService.getCellValueByCell(row.getCell(38));
        militaryStrengthRegistration.engineeringEquipment = commonService.getCellValueByCell(row.getCell(39));
        militaryStrengthRegistration.chemicalPrevention = commonService.getCellValueByCell(row.getCell(40));
        militaryStrengthRegistration.otherForDispatchEquipment = commonService.getCellValueByCell(row.getCell(41));
        militaryStrengthRegistration.totalForEmergencyEquipment = commonService.getCellValueByCell(row.getCell(42));
        militaryStrengthRegistration.antiTerrorismEquipment = commonService.getCellValueByCell(row.getCell(43));
        militaryStrengthRegistration.floodPreventionEquipment = commonService.getCellValueByCell(row.getCell(44));
        militaryStrengthRegistration.ruinsRescueEquipment = commonService.getCellValueByCell(row.getCell(45));
        militaryStrengthRegistration.forestFireFightingEquipment = commonService.getCellValueByCell(row.getCell(46));
        militaryStrengthRegistration.fightSnowEquipment = commonService.getCellValueByCell(row.getCell(47));
        militaryStrengthRegistration.riverSalvageEquipment = commonService.getCellValueByCell(row.getCell(48));
        militaryStrengthRegistration.helicopterEquipment = commonService.getCellValueByCell(row.getCell(49));
        militaryStrengthRegistration.shipboardEquipment = commonService.getCellValueByCell(row.getCell(50));
        militaryStrengthRegistration.carsForEmergencyEquipment = commonService.getCellValueByCell(row.getCell(51));
        militaryStrengthRegistration.engineeringForEmergencyEquipment = commonService.getCellValueByCell(row.getCell(52));
        militaryStrengthRegistration.uav = commonService.getCellValueByCell(row.getCell(53));
        militaryStrengthRegistration.othersForEmergencyEquipment = commonService.getCellValueByCell(row.getCell(54));
        militaryStrengthRegistration.transferPeopleCount = commonService.getCellValueByCell(row.getCell(55));
        militaryStrengthRegistration.rescuePeopleCount = commonService.getCellValueByCell(row.getCell(56));
        militaryStrengthRegistration.recoverEconomicLost = commonService.getCellValueByCell(row.getCell(57));
        militaryStrengthRegistration.transportationMaterials = commonService.getCellValueByCell(row.getCell(58));
        militaryStrengthRegistration.reinforceDyke = commonService.getCellValueByCell(row.getCell(59));
        militaryStrengthRegistration.earthworkExcavation = commonService.getCellValueByCell(row.getCell(60));
        militaryStrengthRegistration.putOutMountainFile = commonService.getCellValueByCell(row.getCell(61));
        militaryStrengthRegistration.otherOutput = commonService.getCellValueByCell(row.getCell(62));
        militaryStrengthRegistration.basicResultOfSupportMilitary = commonService.getCellValueByCell(row.getCell(63));
        militaryStrengthRegistration.otherResultOfSupportMilitary = commonService.getCellValueByCell(row.getCell(64));
        militaryStrengthRegistration.basicResultOfMilitary = commonService.getCellValueByCell(row.getCell(65));
        militaryStrengthRegistration.otherResultOfMilitary = commonService.getCellValueByCell(row.getCell(66));
        militaryStrengthRegistration.district = commonService.getCellValueByCell(row.getCell(67));
        militaryStrengthRegistration.identity = identity;

        //todo 判重 击中了就continue
        militaryStrengthRegistrationMapper.insert(militaryStrengthRegistration);
    }

    private Workbook getWorkbook() throws IOException, InvalidFormatException {
        String templatePath = templateUrl + "military_strength_registration.xlsx";
        FileInputStream inputStream = new FileInputStream(templatePath);
        OPCPackage pkg = OPCPackage.open(inputStream);
        return new XSSFWorkbook(pkg);
    }

    private void fillRows(MilitaryStrengthRegistration militaryStrengthRegistration, Sheet sheet, int i) {
        int index = 8 + i;
        Row row = sheet.createRow(index);
        row.createCell(0).setCellValue(militaryStrengthRegistration.id);
        row.createCell(1).setCellValue(militaryStrengthRegistration.requiredBy);
        row.createCell(2).setCellValue(militaryStrengthRegistration.taskType);
        row.createCell(3).setCellValue(militaryStrengthRegistration.startToEndTime);
        row.createCell(4).setCellValue(militaryStrengthRegistration.concreteTask);
        row.createCell(5).setCellValue(militaryStrengthRegistration.requirementNumber);
        row.createCell(6).setCellValue(militaryStrengthRegistration.taskPlace);
        row.createCell(7).setCellValue(militaryStrengthRegistration.approvalBy);
        row.createCell(8).setCellValue(militaryStrengthRegistration.approvalFileName);
        row.createCell(9).setCellValue(militaryStrengthRegistration.issuedNumber);
        row.createCell(10).setCellValue(militaryStrengthRegistration.commandUnit);
        row.createCell(11).setCellValue(militaryStrengthRegistration.commandInfo);
        row.createCell(12).setCellValue(militaryStrengthRegistration.fundsSource);
        row.createCell(13).setCellValue(militaryStrengthRegistration.subsidyStandard);
        row.createCell(14).setCellValue(militaryStrengthRegistration.equipmentRequirement);
        row.createCell(15).setCellValue(militaryStrengthRegistration.totalPeopleForLooseUse);
        row.createCell(16).setCellValue(militaryStrengthRegistration.totalPeopleDayForLooseUse);
        row.createCell(17).setCellValue(militaryStrengthRegistration.normalPeopleForLooseUse);
        row.createCell(18).setCellValue(militaryStrengthRegistration.normalPeopleDayForLooseUse);
        row.createCell(19).setCellValue(militaryStrengthRegistration.jiganPeopleForLooseUse);
        row.createCell(20).setCellValue(militaryStrengthRegistration.jiganPeopleDayForLooseUse);
        row.createCell(21).setCellValue(militaryStrengthRegistration.newPowerPeopleForLooseUse);
        row.createCell(22).setCellValue(militaryStrengthRegistration.newPowerPeopleDayForLooseUse);
        row.createCell(23).setCellValue(militaryStrengthRegistration.totalTeamForSystemUse);
        row.createCell(24).setCellValue(militaryStrengthRegistration.totalPeopleForSystemUse);
        row.createCell(25).setCellValue(militaryStrengthRegistration.totalPeopleDayForSystemUse);
        row.createCell(26).setCellValue(militaryStrengthRegistration.normalMinbingTeamNameForSystemUse);
        row.createCell(27).setCellValue(militaryStrengthRegistration.normalMinbingPeopleForSystemUse);
        row.createCell(28).setCellValue(militaryStrengthRegistration.normalMinbingPeopleDayForSystemUse);
        row.createCell(29).setCellValue(militaryStrengthRegistration.jiganMinbingTeamNameForSystemUse);
        row.createCell(30).setCellValue(militaryStrengthRegistration.jiganMinbingPeopleForSystemUse);
        row.createCell(31).setCellValue(militaryStrengthRegistration.jiganMinbingPeopleDayForSystemUse);
        row.createCell(32).setCellValue(militaryStrengthRegistration.newPowerPeopleForSystemUse);
        row.createCell(33).setCellValue(militaryStrengthRegistration.newPowerPeopleDayForSystemUse);
        row.createCell(34).setCellValue(militaryStrengthRegistration.totalDisptachEquipment);
        row.createCell(35).setCellValue(militaryStrengthRegistration.lightWeapon);
        row.createCell(36).setCellValue(militaryStrengthRegistration.observationEquipment);
        row.createCell(37).setCellValue(militaryStrengthRegistration.communicationEquipment);
        row.createCell(38).setCellValue(militaryStrengthRegistration.carEquipment);
        row.createCell(39).setCellValue(militaryStrengthRegistration.engineeringEquipment);
        row.createCell(40).setCellValue(militaryStrengthRegistration.chemicalPrevention);
        row.createCell(41).setCellValue(militaryStrengthRegistration.otherForDispatchEquipment);
        row.createCell(42).setCellValue(militaryStrengthRegistration.totalForEmergencyEquipment);
        row.createCell(43).setCellValue(militaryStrengthRegistration.antiTerrorismEquipment);
        row.createCell(44).setCellValue(militaryStrengthRegistration.floodPreventionEquipment);
        row.createCell(45).setCellValue(militaryStrengthRegistration.ruinsRescueEquipment);
        row.createCell(46).setCellValue(militaryStrengthRegistration.forestFireFightingEquipment);
        row.createCell(47).setCellValue(militaryStrengthRegistration.fightSnowEquipment);
        row.createCell(48).setCellValue(militaryStrengthRegistration.riverSalvageEquipment);
        row.createCell(49).setCellValue(militaryStrengthRegistration.helicopterEquipment);
        row.createCell(50).setCellValue(militaryStrengthRegistration.shipboardEquipment);
        row.createCell(51).setCellValue(militaryStrengthRegistration.carsForEmergencyEquipment);
        row.createCell(52).setCellValue(militaryStrengthRegistration.engineeringForEmergencyEquipment);
        row.createCell(53).setCellValue(militaryStrengthRegistration.uav);
        row.createCell(54).setCellValue(militaryStrengthRegistration.othersForEmergencyEquipment);
        row.createCell(55).setCellValue(militaryStrengthRegistration.transferPeopleCount);
        row.createCell(56).setCellValue(militaryStrengthRegistration.rescuePeopleCount);
        row.createCell(57).setCellValue(militaryStrengthRegistration.recoverEconomicLost);
        row.createCell(58).setCellValue(militaryStrengthRegistration.transportationMaterials);
        row.createCell(59).setCellValue(militaryStrengthRegistration.reinforceDyke);
        row.createCell(60).setCellValue(militaryStrengthRegistration.earthworkExcavation);
        row.createCell(61).setCellValue(militaryStrengthRegistration.putOutMountainFile);
        row.createCell(62).setCellValue(militaryStrengthRegistration.otherOutput);
        row.createCell(63).setCellValue(militaryStrengthRegistration.basicResultOfSupportMilitary);
        row.createCell(64).setCellValue(militaryStrengthRegistration.otherResultOfSupportMilitary);
        row.createCell(65).setCellValue(militaryStrengthRegistration.basicResultOfMilitary);
        row.createCell(66).setCellValue(militaryStrengthRegistration.otherResultOfMilitary);
    }
}
