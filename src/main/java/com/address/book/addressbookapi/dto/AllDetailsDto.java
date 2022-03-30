package com.address.book.addressbookapi.dto;

import com.address.book.addressbookapi.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AllDetailsDto {
    private CustomerDto customerDto;
}
