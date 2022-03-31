package com.address.book.addressbookapi.controller;

import com.address.book.addressbookapi.dto.AllDetailsDto;
import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.dto.ExternalContactDto;
import com.address.book.addressbookapi.entity.AllDetails;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.externalService.ExternalServiceApis;
import com.address.book.addressbookapi.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerServiceImp customerServiceImp;

    @Autowired
    public ExternalServiceApis externalServiceApis;

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

    @PostMapping("/saveDto")
    public Customer save(@RequestBody AllDetailsDto allDetailsDtoDto) {
        return customerServiceImp.saveDto(allDetailsDtoDto);
    }

    @PutMapping("/delete/{id}")
    public Customer delete(@PathVariable int id) {
        return customerServiceImp.delete(id);
    }

    @GetMapping("/externalFindAll")
    public String externalFindAll() {
        return externalServiceApis.externalFindAll();
    }

    @PostMapping("/externalSave")
    public String externalSave(@RequestBody ExternalContactDto externalContactDto) {
        return externalServiceApis.externalSave(externalContactDto);
    }

    @GetMapping("/externalFindAll/{firstName}")
    public String externalSearchByName(@PathVariable String firstName) {
        return externalServiceApis.externalSearchByFirstName(firstName);
    }

    @PutMapping("/externalUpdate/{id}")
    public String externalUpdate(@PathVariable Long id) {
        return externalServiceApis.externalUpdate(id);
    }

}

