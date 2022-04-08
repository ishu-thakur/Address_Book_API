package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.exceptionhandling.ListEmptyException;
import com.address.book.addressbookapi.mapper.ObjectMapper;
import com.address.book.addressbookapi.repo.CustomerRepo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExcelServiceImp implements ExcelService {



    @Autowired
    private CustomerRepo customerRepo;

    Logger logger = LoggerFactory.getLogger(ExcelServiceImp.class);

    @Override
    public List<CustomerDto> findAll() {
        logger.info("we are in FindAll in ExcelServiceImp");
        List<CustomerDto> customerDtoList = ObjectMapper.INSTACNE.entityListToDto(customerRepo.findAll());
        if (customerDtoList.isEmpty()) {
            throw new ListEmptyException();
        } else {
            return customerDtoList;
        }
    }

    public void uploadAll(MultipartFile file) throws IOException {
        logger.info("we are in uploadAll in ExcelServiceImp");
        List<Customer> customerDtoList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
            Customer customer = new Customer();

            XSSFRow row = worksheet.getRow(i);

            customer.setContactId((int) row.getCell(0).getNumericCellValue());
            customer.setFirstName(row.getCell(1).getStringCellValue());
            customer.setLastName(row.getCell(2).getStringCellValue());
            customer.setEmailAddress(row.getCell(3).getStringCellValue());
            customer.setIsActive(row.getCell(4).getStringCellValue());
            customer.setCreatedBy(row.getCell(5).getStringCellValue());
            customer.setUpdatedBy(row.getCell(6).getStringCellValue());
            customerDtoList.add(customer);
        }
        StopWatch stopWatch = new StopWatch();
        customerRepo.saveAll(customerDtoList);
        stopWatch.stop();
        logger.info("save time : " ,stopWatch.getTotalTimeSeconds());
    }
}
