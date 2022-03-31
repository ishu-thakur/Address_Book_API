package com.address.book.addressbookapi.repo;

import com.address.book.addressbookapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findByFirstName(String firstName);
//    @Modifying
//    @Query("UPDATE Customer SET IS_ACTIVE ='N', WHERE CONTACT_ID = :id")
//    void updateIsActive(int id);
//    @Modifying
//    @Query("UPDATE Customer c SET c.isActive = 'N' WHERE c.CONTACT_ID = :id")
//    void updateIsActive(@Param("id") int id);
}
