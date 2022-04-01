package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.Customer;
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
        return mapper.INSTACNE.entityListToDto(customerRepo.findAll());
    }


    @Override
    public List<CustomerDto> findByName(String firstName) {

//        Customer foundByFirstName =
        return mapper.INSTACNE.entityListToDto(customerRepo.findByFirstName(firstName));
//        if (foundByFirstName.getIsActive() == "N") {
//            return null;
//        } else {
//            return foundByFirstName;
//        }
    }


    @Override
    public CustomerDto saveDto(CustomerDto customerDto) {
        return mapper.INSTACNE.custEntityToDto(customerRepo.save(mapper.INSTACNE.custDtoToEntity(customerDto)));
    }

    @Override
    public String delete(Long id) {
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
