package com.address.book.addressbookapi.mapper;


import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface mapper {

    mapper INSTACNE = Mappers.getMapper(mapper.class);

    Customer custDtoToEntity(CustomerDto customerDto);

    CustomerDto custEntityToDto(Customer customer);

    List<CustomerDto> entityListToDto(List<Customer> customers);


}
