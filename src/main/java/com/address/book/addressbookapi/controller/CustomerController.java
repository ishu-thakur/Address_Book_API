package com.address.book.addressbookapi.controller;

import com.address.book.addressbookapi.entity.AllDetails;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerServiceImp customerServiceImp;

    @GetMapping("/findByName/{firstName}")
    public Customer findByname(@PathVariable String firstName) {
        return customerServiceImp.findByName(firstName);

    }

    @GetMapping("/findAll")
    public List<Customer> findAll() {
        return customerServiceImp.findAll();
    }

    @PostMapping("/save")
    public Customer save(@RequestBody AllDetails allDetails) {
        return customerServiceImp.save(allDetails);
    }

    @PutMapping("/delete/{id}")
    public Customer delete(@PathVariable int id) {
         return customerServiceImp.delete(id);
    }
}

