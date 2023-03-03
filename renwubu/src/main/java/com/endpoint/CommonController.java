package com.endpoint;


import com.model.BaseResponse;
import com.model.request.DeleteItemRequest;
import com.model.request.DownloadExcelRequest;
import com.model.request.UploadExcelRequest;
import com.service.CommonService;
import com.service.excelhandler.ExcelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 兵役服务
 *
 * @author wuyuxiao
 */
@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 删除
     *
     * @param request
     * @return
     */
    @PostMapping("/delete_item")
    public BaseResponse<Boolean> deleteItem(@RequestBody DeleteItemRequest request) {
        try {

            commonService.deleteItem(request);
            return BaseResponse.ok(true);
        } catch (Exception e) {
            return BaseResponse.failed(e.getLocalizedMessage());
        }
    }


    @Autowired
    private List<ExcelHandler> excelHandlerList;

    /**
     * 表单上传接口
     *
     * @return
     */
    @PostMapping("/upload_excel")
    public BaseResponse<Boolean> uploadExcel(@RequestPart(value = "file", required = false) MultipartFile file, @RequestPart("content") UploadExcelRequest
            request) {
        for (ExcelHandler excelHandler : excelHandlerList
        ) {
            if (excelHandler.getExcelType().equals(request.getType())) {
                excelHandler.upload(file,request.getIdentity());
            }
        }
        return BaseResponse.ok(true);

    }

    /**
     * 表单下载接口
     *
     * @return
     */
    @PostMapping("/download_excel")
    public BaseResponse<String> downloadExcel(@RequestBody DownloadExcelRequest request) throws IOException {
        String result = null;
        for (ExcelHandler excelHandler : excelHandlerList
        ) {
            if (excelHandler.getExcelType().equals(request.getType())) {
                result = excelHandler.download(request.getIdentity());
            }
        }
        return BaseResponse.ok(result);

    }
}
