package com.address.book.addressbookapi.controller;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.service.CustomerServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerServiceImp customerServiceImp;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @ApiOperation("Find the record by first name")
    @GetMapping("/findByName")

    public List<CustomerDto> findByName(@RequestParam(required = true) String firstName, @RequestParam String isRemote) throws JsonProcessingException {
        logger.info("We are in the findByName Api");
        return customerServiceImp.findByName(firstName, isRemote);

    }


    @ApiOperation("Find all records present in database")
    @GetMapping("/findAll")
    public List<CustomerDto> findAll(@RequestParam String isRemote) throws JsonProcessingException {
        return customerServiceImp.findAll(isRemote);
    }


    @ApiOperation("Save the data in the DTO format")
    @PostMapping("/saveDto")
    public CustomerDto saveDto(@Valid @RequestBody CustomerDto customerDto, @RequestParam String isRemote) throws JsonProcessingException {
        return customerServiceImp.saveDto(customerDto, isRemote);
    }


    @ApiOperation("Delete the record by changing isActive")
    @PutMapping("/delete")
    public String delete(@RequestParam(required = true) Integer id, @RequestParam String isRemote) {
        return customerServiceImp.delete(id, isRemote);
    }

}

