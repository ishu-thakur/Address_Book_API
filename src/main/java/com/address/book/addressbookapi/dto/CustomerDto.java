package com.address.book.addressbookapi.dto;

import com.address.book.addressbookapi.entity.Mobile;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class CustomerDto {

    @JsonProperty("contactId")
    private int CONTACT_ID;
    @JsonProperty("firstName")
    private String FIRST_NAME;
    @JsonProperty("lastName")
    private String LAST_NAME;
    @JsonProperty("email")
    private String EMAIL_ADDRESS;
    @JsonProperty("createdBy")
    private String CREATED_BY;
    @JsonProperty("createdDate")
    private Date CREATED_DATE;
    @JsonProperty("updatedBy")
    private String UPDATED_BY;
    @JsonProperty("updatedDate")
    private Date UPDATED_DATE;
    @JsonProperty("isActive")
    private String IS_ACTIVE;
    private List<MobileDto> mobile_details;
}
