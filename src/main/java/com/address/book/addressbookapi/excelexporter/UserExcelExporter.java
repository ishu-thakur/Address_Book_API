package com.address.book.addressbookapi.excelexporter;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.Mobile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UserExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<CustomerDto> listUsers;
    Logger logger = LoggerFactory.getLogger(UserExcelExporter.class);

    public UserExcelExporter(List<CustomerDto> listUsers) {
        logger.info("We are in the UserExcelExporter inside the UserExcelExport");
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        logger.info("We are in the writeHeaderLine inside the UserExcelExport");
        sheet = workbook.createSheet("ADDRESS_BOOK");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.BIG_SPOTS);

        createCell(row, 0, "Contact_ID", style);
        createCell(row, 1, "FIRST_NAME", style);
        createCell(row, 2, "LAST_NAME", style);
        createCell(row, 3, "EMAIL_ADDRESS", style);
        createCell(row, 4, "IS_ACTIVE", style);
        createCell(row, 5, "CREATED_BY", style);
        createCell(row, 6, "CREATED_DATE", style);
        createCell(row, 7, "UPDATED_BY", style);
        createCell(row, 8, "UPDATED_DATE", style);

        createCell(row, 9, "MOBILE_ID", style);
        createCell(row, 10, "MOBILE_NUMBER", style);
        createCell(row, 11, "COUNTRY_CODE", style);
        createCell(row, 12, "TYPE", style);
        createCell(row, 13, "CREATED_BY", style);
        createCell(row, 14, "CREATED_DATE", style);
        createCell(row, 15, "UPDATED_BY", style);
        createCell(row, 16, "UPDATED_DATE", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        logger.info("We are in the createCell inside the UserExcelExport");
        sheet.autoSizeColumn(columnCount);

        Cell cell = row.createCell(columnCount);

        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Date) {
            CreationHelper createHelper = workbook.getCreationHelper();
            style.setDataFormat(
                    createHelper.createDataFormat().getFormat("YYYY-MM-DD"));
            cell.setCellValue((Date) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        logger.info("We are in the writeDataLines inside the UserExcelExport");
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);


        for (CustomerDto user : listUsers) {
            CellStyle cellStyle = setColor(user);
            style = cellStyle;
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, user.getContactId().toString(), style);
            createCell(row, columnCount++, user.getFirstName(), style);
            createCell(row, columnCount++, user.getLastName(), style);
            createCell(row, columnCount++, user.getEmailAddress(), style);
            createCell(row, columnCount++, user.getIsActive(), style);
            createCell(row, columnCount++, user.getCreatedBy(), style);
            createCell(row, columnCount++, user.getCreatedDate(), style);
            createCell(row, columnCount++, user.getUpdatedBy(), style);
            createCell(row, columnCount++, user.getUpdatedDate(), style);
            for (Mobile mobile : user.getMobileEntities()) {
                createCell(row, columnCount++, mobile.getMobileId().toString(), style);
                createCell(row, columnCount++, mobile.getMobileNumber(), style);
                createCell(row, columnCount++, mobile.getCountryCode(), style);
                createCell(row, columnCount++, mobile.getType(), style);
                createCell(row, columnCount++, mobile.getCreatedBy(), style);
                createCell(row, columnCount++, mobile.getCreatedDate(), style);
                createCell(row, columnCount++, mobile.getUpdatedBy(), style);
                createCell(row, columnCount++, mobile.getUpdatedDate(), style);
            }
        }
    }

    CellStyle setColor(CustomerDto customerDto) {
        logger.info("We are in the setColor inside the UserExcelExport");
        CellStyle cellStyle = workbook.createCellStyle();

        if (customerDto.getContactId() % 2 == 0) {
            cellStyle.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            cellStyle.setFillPattern(FillPatternType.BIG_SPOTS);
        } else {
            cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
            cellStyle.setFillPattern(FillPatternType.DIAMONDS);
        }

        return cellStyle;
    }

    public void export(HttpServletResponse response) throws IOException {
        logger.info("We are in the export inside the UserExcelExport");
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
