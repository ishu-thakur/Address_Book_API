package com.address.book.addressbookapi.dto;

import com.address.book.addressbookapi.entity.ExternalMobileEntity;
import com.address.book.addressbookapi.entity.Mobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

//    @JsonProperty("contactId")
//    private int CONTACT_ID;
//    @JsonProperty("firstName")
//    private String FIRST_NAME;
//    @JsonProperty("lastName")
//    private String LAST_NAME;
//    @JsonProperty("email")
//    private String EMAIL_ADDRESS;
//    @JsonProperty("createdBy")
//    private String CREATED_BY;
//    @JsonProperty("createdDate")
//    private Date CREATED_DATE;
//    @JsonProperty("updatedBy")
//    private String UPDATED_BY;
//    @JsonProperty("updatedDate")
//    private Date UPDATED_DATE;
//    @JsonProperty("isActive")
//    private String IS_ACTIVE;


//    private int contactId;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String email;
//
//    private String createdBy;
//
//    private Date createdDate;
//
//    private String updatedBy;
//
//    private Date updatedDate;
//
//    private String isActive;
//    private List<Mobile> mobile_details;

    private Long contactId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private List<Mobile> mobileEntities;

    private String isActive;
}
