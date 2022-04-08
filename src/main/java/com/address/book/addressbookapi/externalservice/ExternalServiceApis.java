package com.address.book.addressbookapi.externalservice;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ExternalServiceApis {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${external.url}")
    private String externalUrl;

    ObjectMapper objectMapper = new ObjectMapper();
    Logger logger = LoggerFactory.getLogger(ExternalServiceApis.class);

    public CustomerDto[] externalFindAll() throws JsonProcessingException {
        logger.info("we are in externalFindAll in ExternalServiceApis");
        String listOfCustomer = restTemplate.getForObject(externalUrl + "search/connectToExternalMachine=false", String.class);
        return objectMapper.readValue(listOfCustomer, CustomerDto[].class);
    }

    public CustomerDto externalSave(CustomerDto customerDto) throws JsonProcessingException {
        logger.info("we are in externalSave in ExternalServiceApis");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = objectMapper.writeValueAsString(customerDto);
        HttpEntity<String> entity = new HttpEntity<>(jsonString, httpHeaders);
        String responseEntity = restTemplate.postForObject(externalUrl + "save/connectToExternalMachine=false", entity, String.class);
        return objectMapper.readValue(responseEntity, CustomerDto.class);

    }

    public String externalUpdate(Integer id){
        logger.info("we are in externalUpdate in ExternalServiceApis");
        restTemplate.put(externalUrl + "update/connectToExternalMachine=false/" + id, String.class);
        return "Data have been updated in the external Api";

    }

    public CustomerDto[] externalSearchByFirstName(String firstName) throws JsonProcessingException {
        logger.info("we are in externalSearchByFirstName in ExternalServiceApis");
        String findOne = restTemplate.getForObject(externalUrl + "search/connectToExternalMachine=false/" + firstName, String.class);
        return objectMapper.readValue(findOne, CustomerDto[].class);
    }


}
