package com.address.book.addressbookapi.controller;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.externalService.ExternalServiceApis;
import com.address.book.addressbookapi.service.CustomerServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public List<CustomerDto> findByname(@PathVariable String firstName, @RequestParam String isRemote) throws JsonProcessingException {
        if (isRemote.equals("yes")) {
            return List.of(externalServiceApis.externalSearchByFirstName(firstName));
        }
        return customerServiceImp.findByName(firstName);

    }

    @GetMapping("/findAll")
    public List<CustomerDto> findAll(@RequestParam String isRemote) throws JsonProcessingException {
        if (isRemote.equals("yes")) {
            return List.of(externalServiceApis.externalFindAll());
        } else {
            return customerServiceImp.findAll();
        }
    }


    @PostMapping("/saveDto")
    public CustomerDto saveDto(@RequestBody CustomerDto customerDto, @RequestParam String isRemote) throws JsonProcessingException {
        if (isRemote.equals("yes")) {
            return externalServiceApis.externalSave(customerDto);
        } else {
            return customerServiceImp.saveDto(customerDto);
        }

    }

    @PutMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @RequestParam String isRemote) throws JsonProcessingException {
        if (isRemote.equals("yes")) {
            return externalServiceApis.externalUpdate(id);
        } else {
            return customerServiceImp.delete(id);
        }

    }


//***********************************************************EXTERNAL APIS************************************************************************************
//    @GetMapping("/externalFindAll")
//    public List<Customer> externalFindAll() throws JsonProcessingException {
//        return List.of(externalServiceApis.externalFindAll());
//    }
//
//    @PostMapping("/externalSave")
//    public ExternalContactDto externalSave(@RequestBody ExternalContactDto externalContactDto) throws JsonProcessingException {
//        return externalServiceApis.externalSave(externalContactDto);
//    }
//
//    @GetMapping("/externalFindAll/{firstName}")
//    public List<ExternalContactDto> externalSearchByName(@PathVariable String firstName) throws JsonProcessingException {
//        return List.of(externalServiceApis.externalSearchByFirstName(firstName));
//    }
//
//    @PutMapping("/externalUpdate/{id}")
//    public String externalUpdate(@PathVariable Long id) throws JsonProcessingException {
//        return externalServiceApis.externalUpdate(id);
//    }

}

