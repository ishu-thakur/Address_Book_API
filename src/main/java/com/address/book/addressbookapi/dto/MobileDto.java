package com.address.book.addressbookapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class MobileDto {

    @JsonProperty("mobileId")
    private int mobile_Id;
    @JsonProperty("mobileNumber")
    private String MOBILE_NUMBER;
    @JsonProperty("countryCd")
    private String COUNTRY_CD;
    @JsonProperty("type")
    private String TYPE;
    @JsonProperty("createdBy")
    private String CREATED_BY;
    @JsonProperty("createdDate")
    private Date CREATED_DATE;
    @JsonProperty("updatedBy")
    private String UPDATED_BY;
    @JsonProperty("updatedDate")
    private Date UPDATED_DATE;

}
