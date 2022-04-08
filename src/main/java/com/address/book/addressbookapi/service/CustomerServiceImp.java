package com.address.book.addressbookapi.service;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.exceptionhandling.ListEmptyException;
import com.address.book.addressbookapi.externalservice.ExternalServiceApis;
import com.address.book.addressbookapi.mapper.ObjectMapper;
import com.address.book.addressbookapi.repo.CustomerRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    public CustomerRepo customerRepo;
    @Autowired
    public ExternalServiceApis externalServiceApis;

    Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);

    @Override
    public List<CustomerDto> findAll(String isRemote) throws JsonProcessingException {
        logger.info("we are in FindAll in CustomerServiceImp");
        if (isRemote.equalsIgnoreCase("yes")) {
            logger.info("We are in the findAll External Api");
            return List.of(externalServiceApis.externalFindAll());
        }
        logger.info("We are in the findAll Remote Api");
        List<CustomerDto> customerDtoList = ObjectMapper.INSTACNE.entityListToDto(customerRepo.findAll());
        if (customerDtoList.isEmpty()) {
            throw new ListEmptyException();
        }

        return customerDtoList;
    }


    @Override
    public List<CustomerDto> findByName(String firstName, String isRemote) throws JsonProcessingException {
        logger.info("we are in externalFindAll in ExternalServiceApis");
        if (isRemote.equalsIgnoreCase("yes")) {
            logger.info("We are in the findByName External Api");
            return List.of(externalServiceApis.externalSearchByFirstName(firstName));
        }
        logger.info("We are in the findByName Remote Api");
        List<CustomerDto> customerDtoList = ObjectMapper.INSTACNE.entityListToDto(customerRepo.findByFirstName(firstName));
        if (customerDtoList.isEmpty()) {
            throw new ListEmptyException();
        }
        return customerDtoList;
    }


    @Override
    public CustomerDto saveDto(CustomerDto customerDto, String isRemote) throws JsonProcessingException {
        logger.info("we are in saveDto in CustomerServiceImpl");
        if (isRemote.equalsIgnoreCase("yes")) {
            logger.info("We are in the saveDto External Api");
            return externalServiceApis.externalSave(customerDto);
        }
        logger.info("We are in the saveDto Remote Api");
        return ObjectMapper.INSTACNE.custEntityToDto(customerRepo.save(ObjectMapper.INSTACNE.custDtoToEntity(customerDto)));
    }

    @Override
    public String delete(Integer id, String isRemote) {
        logger.info("we are in delete in CustomerServiceImpl");
        if (isRemote.equalsIgnoreCase("yes")) {
            logger.info("We are in the delete External Api");
            return externalServiceApis.externalUpdate(id);
        }
        logger.info("We are in the Delete Remote Api");
        Customer
                foundCustomer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found"));
        foundCustomer.setIsActive("N");
        customerRepo.save(foundCustomer);
        return "Data have been updated";
    }
}
