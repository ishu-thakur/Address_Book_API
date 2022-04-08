package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;


public interface CustomerService {

    public List<CustomerDto> findAll(String isRemote) throws JsonProcessingException;

    public List<CustomerDto> findByName(String firstName,String isRemote) throws JsonProcessingException;

    public CustomerDto saveDto(CustomerDto customerDto,String isRemote) throws JsonProcessingException;

    public String delete(Integer id,String isRemote);
}
