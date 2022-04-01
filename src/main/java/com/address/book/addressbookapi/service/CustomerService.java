package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.entity.ExternalContactEntity;
import com.address.book.addressbookapi.entity.ExternalMobileEntity;

import java.util.List;


public interface CustomerService {

    public List<CustomerDto> findAll();

    public List<CustomerDto> findByName(String firstName);

    public CustomerDto saveDto(CustomerDto customerDto);

    public String delete(Long id);
}
