package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.exceptionHandling.ListEmptyException;
import com.address.book.addressbookapi.mapper.mapper;
import com.address.book.addressbookapi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ExcelServiceImp implements ExcelService {


//  private static final String CSV_FILE_LOCATION = "C:/Users/ishu.thakur/Downloads/AddressBook_2022-04-05_12_56_21.xlsx";
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<CustomerDto> findAll() {
        List<CustomerDto> customerDtoList = mapper.INSTACNE.entityListToDto(customerRepo.findAll());
        if (customerDtoList.isEmpty()) {
            throw new ListEmptyException();
        } else {
            return customerDtoList;
        }
    }

    public void uploadAll() throws IOException {

//        List<Customer> courses = new ArrayList<>();
//
//        Workbook workbook =null;
//
//            // Creating a Workbook from an Excel file (.xls or .xlsx)
//            workbook = WorkbookFactory.create(new File(CSV_FILE_LOCATION));
//
//            workbook.forEach(sheet -> {
//
//                // Create a DataFormatter to format and get each cell's value as String
//                DataFormatter dataFormatter = new DataFormatter();
//
//                //loop through all rows and columns and create Course object
//                int index = 0;
//                for(Row row : sheet) {
//                    if(index++ == 0) continue;
//
//                    Customer course = new Customer();
//                    course.setContactId(Integer.valueOf(dataFormatter.formatCellValue(row.getCell(0))));
//                    course.setFirstName(dataFormatter.formatCellValue(row.getCell(1)));
//                    course.setLastName(dataFormatter.formatCellValue(row.getCell(2)));
//                    course.setEmailAddress(dataFormatter.formatCellValue(row.getCell(3)));
//                    course.setIsActive(dataFormatter.formatCellValue(row.getCell(4)));
//                    course.setCreatedBy(dataFormatter.formatCellValue(row.getCell(5)));
//                    course.setUpdatedBy(dataFormatter.formatCellValue(row.getCell(6)));
//                    courses.add(course);
//                }
//
//                customerRepo.saveAll(courses);
//            });

//        return courses;
         customerRepo.uploadAllFromExcelToDatabase();
    }
}
