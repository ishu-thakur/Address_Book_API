package com.address.book.addressbookapi.controller;

import com.address.book.addressbookapi.ExcelExporter.UserExcelExporter;
import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.service.ExcelServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
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

    @PostMapping("/upload?allowLoadLocalInfile=true")
    public String uploadFile() throws IOException {
        excelServiceImp.uploadAll();
        return "data have been uploaded";
    }

}
