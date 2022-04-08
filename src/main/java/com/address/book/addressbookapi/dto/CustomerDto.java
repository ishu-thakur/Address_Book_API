package com.address.book.addressbookapi.dto;

import com.address.book.addressbookapi.entity.Mobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Integer contactId;


    private String firstName;


    private String lastName;


    private String emailAddress;


    private String createdBy;

    private Date createdDate;


    private String updatedBy;

    private Date updatedDate;


    private String isActive;

    private List<Mobile> mobileEntities;
}
