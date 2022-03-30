package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.entity.AllDetails;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void delete(int id) {
        Optional<Customer> foundCustomer = customerRepo.findById(id);
        if (foundCustomer.get().getIsActive() == "Y") {
            foundCustomer.get().setIsActive("N");
        }

    }
}
