package com.address.book.addressbookapi.externalService;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.dto.ExternalContactDto;
import com.address.book.addressbookapi.entity.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ExternalServiceApis {

    @Autowired
    private RestTemplate restTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    public CustomerDto[] externalFindAll() throws JsonProcessingException {

//        http://10.50.2.201:8085/search
        String listOfCustomer = restTemplate.getForObject("http://10.50.2.201:8085/search/isRemote=n", String.class);
        return objectMapper.readValue(listOfCustomer, CustomerDto[].class);
    }

    public CustomerDto externalSave(CustomerDto customerDto) throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = objectMapper.writeValueAsString(customerDto);
        HttpEntity<String> entity = new HttpEntity<>(jsonString, httpHeaders);
        String responseEntity = restTemplate.postForObject("http://10.50.2.201:8085/save/isRemote=n", entity, String.class);
        return objectMapper.readValue(responseEntity, CustomerDto.class);

    }

    public String externalUpdate(Long id) throws JsonProcessingException {

//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            HttpEntity<ExternalContactDto> entity = new HttpEntity<ExternalContactDto>(httpHeaders);
//            String updateOne = restTemplate.exchange("http://10.50.2.201:8085/update/" + id, HttpMethod.PUT, entity, String.class).getBody();

        restTemplate.put("http://10.50.2.201:8085/update/" + id + "/isRemote=n+", String.class);
        return "Data have been updated in the external Api";
//        return objectMapper.readValue(updateOne,ExternalContactDto.class);
    }

    public CustomerDto[] externalSearchByFirstName(String firstName) throws JsonProcessingException {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
        String findOne = restTemplate.getForObject("http://10.50.2.201:8085/search/" + firstName + "/isRemote=n", String.class);
        return objectMapper.readValue(findOne, CustomerDto[].class);
    }


}
