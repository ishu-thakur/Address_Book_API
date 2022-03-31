package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.AllDetailsDto;
import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.AllDetails;
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
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findByName(String firstName) {

        Customer foundByFirstName = customerRepo.findByFirstName(firstName);
        if (foundByFirstName.getIsActive() == "N") {
            return null;
        } else {
            return foundByFirstName;
        }
    }

    @Override
    public Customer save(AllDetails allDetails) {
        return customerRepo.save(allDetails.getCustomer());
    }

//    @Override
//    public CustomerDto save(AllDetailsDto allDetailsDto) {
//      return customerRepo.save(mapper.INSTACNE.allDetailsDtoToEntity(allDetailsDto.getCustomerDto()));
//    }

    @Override
    public Customer delete(int id) {
        Customer
                foundCustomer = customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Data not found"));
            foundCustomer.setIsActive("N");
            customerRepo.save(foundCustomer);
    return foundCustomer;
    }
}
