package com.address.book.addressbookapi.service;


import com.address.book.addressbookapi.dto.CustomerDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface ExcelService {
    List<CustomerDto> findAll();
    void uploadAll(MultipartFile file) throws IOException;
}
