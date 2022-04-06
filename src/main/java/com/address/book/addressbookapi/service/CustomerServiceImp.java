package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.exceptionHandling.ListEmptyException;
import com.address.book.addressbookapi.mapper.mapper;
import com.address.book.addressbookapi.repo.CustomerRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    public CustomerRepo customerRepo;

    @Override
    public List<CustomerDto> findAll() {
        List<CustomerDto> customerDtoList = mapper.INSTACNE.entityListToDto(customerRepo.findAll());
        if (customerDtoList.isEmpty()) {
            throw new ListEmptyException();
        } else {
            return customerDtoList;
        }
    }


    @Override
    public List<CustomerDto> findByName(String firstName) {
        List<CustomerDto> customerDtoList = mapper.INSTACNE.entityListToDto(customerRepo.findByFirstName(firstName));
        if (customerDtoList.isEmpty()) {
            throw new ListEmptyException();
        } else {
            return customerDtoList;
        }
    }


    @Override
    public CustomerDto saveDto(CustomerDto customerDto) {
        CustomerDto saveData = null;
        for (int i = 0; i < 50000; i++) {
             saveData = mapper.INSTACNE.custEntityToDto(customerRepo.save(mapper.INSTACNE.custDtoToEntity(customerDto)));
        }
        return saveData;
    }

    @Override
    public String delete(Integer id) {
//
//        if(!ObjectUtils.isEmpty(isRemote) && isRemote.equals("Y")) {
//            // fetch data from remote machine
//        } else {
//            local db
//        }
        Customer
                foundCustomer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found"));
        foundCustomer.setIsActive("N");
        customerRepo.save(foundCustomer);
        return "Data have been updated";
    }
}
