package com.address.book.addressbookapi.controller;

import com.address.book.addressbookapi.excelexporter.UserExcelExporter;
import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.service.ExcelServiceImp;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private ExcelServiceImp excelServiceImp;

    Logger logger = LoggerFactory.getLogger(ExcelController.class);

    @ApiOperation("Downloading the records in excel format")
    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        logger.info("we are in the controller");
        //it is an application or a document that is opened in an application such as a spreadsheet or word processor.
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=AddressBook_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<CustomerDto> listUsers = excelServiceImp.findAll();

        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);

        excelExporter.export(response);
    }

    @ApiOperation("Uploading the records from excel to Database")
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile reapExcelDataFile) throws IOException {
        logger.info("we are in the controller");
        excelServiceImp.uploadAll(reapExcelDataFile);
        return "data have been uploaded";
    }

}
