package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.entity.AllDetails;
import com.address.book.addressbookapi.entity.Customer;

import java.util.List;


public interface CustomerService {

    public List<Customer> findAll();
    public Customer findByName(String firstName);
    public Customer save(AllDetails allDetails);
    public void delete(int id);
}
