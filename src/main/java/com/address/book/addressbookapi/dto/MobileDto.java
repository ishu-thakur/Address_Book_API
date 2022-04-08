package com.address.book.addressbookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MobileDto {

    private Integer mobileId;
    private String mobileNumber;
    private String countryCd;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
}
