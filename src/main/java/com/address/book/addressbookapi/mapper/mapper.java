package com.address.book.addressbookapi.mapper;


import com.address.book.addressbookapi.dto.AllDetailsDto;
import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.dto.MobileDto;
import com.address.book.addressbookapi.entity.AllDetails;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.entity.Mobile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface mapper {

    mapper INSTACNE = Mappers.getMapper(mapper.class);

    Customer custDtoToEntity(CustomerDto customerDto);
    CustomerDto custEntityToDto(Customer customer);


    Mobile mobileDtoToEntity(MobileDto mobileDto);
    MobileDto mobileEntityToDto(Mobile mobile);



    Object allDetailsDtoToEntity(Customer customer);
//    AllDetails allDetailsDtoToEntity(AllDetailsDto allDetailsDto);
//    AllDetailsDto allDetailsEntityToDto(AllDetails allDetails);

}
