package com.address.book.addressbookapi.repo;

import com.address.book.addressbookapi.dto.CustomerDto;
import com.address.book.addressbookapi.entity.Customer;
import com.address.book.addressbookapi.entity.ExternalContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstName(String firstName);
//    @Modifying
//    @Query("UPDATE Customer SET IS_ACTIVE ='N', WHERE CONTACT_ID = :id")
//    void updateIsActive(int id);
//    @Modifying
//    @Query("UPDATE Customer c SET c.isActive = 'N' WHERE c.CONTACT_ID = :id")
//    void updateIsActive(@Param("id") int id);
}
