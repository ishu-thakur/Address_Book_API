package com.address.book.addressbookapi.externalService;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public CustomerDto[] externalFindAll() throws JsonProcessingException {

        String listOfCustomer = restTemplate.getForObject(externalUrl + "search/isRemote=n", String.class);
        return objectMapper.readValue(listOfCustomer, CustomerDto[].class);
    }

    public CustomerDto externalSave(CustomerDto customerDto) throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String jsonString = objectMapper.writeValueAsString(customerDto);
        HttpEntity<String> entity = new HttpEntity<>(jsonString, httpHeaders);
        String responseEntity = restTemplate.postForObject(externalUrl + "save/isRemote=n", entity, String.class);
        return objectMapper.readValue(responseEntity, CustomerDto.class);

    }

    public String externalUpdate(Integer id) throws JsonProcessingException {

//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            HttpEntity<ExternalContactDto> entity = new HttpEntity<ExternalContactDto>(httpHeaders);
//            String updateOne = restTemplate.exchange("http://10.50.2.201:8085/update/" + id, HttpMethod.PUT, entity, String.class).getBody();

        restTemplate.put(externalUrl + "update/isRemote=n/" + id, String.class);
        return "Data have been updated in the external Api";
//        return objectMapper.readValue(updateOne,ExternalContactDto.class);
    }

    public CustomerDto[] externalSearchByFirstName(String firstName) throws JsonProcessingException {
        String findOne = restTemplate.getForObject(externalUrl + "search/isRemote=n/" + firstName, String.class);
        return objectMapper.readValue(findOne, CustomerDto[].class);
    }


}
