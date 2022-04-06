package com.address.book.addressbookapi.repo;

import com.address.book.addressbookapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstName(String firstName);
//    @Modifying
//    @Query("UPDATE Customer SET IS_ACTIVE ='N', WHERE CONTACT_ID = :id")
//    void updateIsActive(int id);
//    @Modifying
//    @Query("UPDATE Customer c SET c.isActive = 'N' WHERE c.CONTACT_ID = :id")
//    void updateIsActive(@Param("id") int id);

//    *****************************************MY SQL **************************************************************************
    @Modifying
    @Query(
            value = "LOAD DATA LOCAL INFILE 'C:/Users/ishu.thakur/Downloads/AddressBook_2022-04-05_12_56_21.csv' INTO TABLE address_book.customer FIELDS TERMINATED BY ',' LINES terminated by '\n'",
    nativeQuery = true)
    void uploadAllFromExcelToDatabase();


    //    *****************************************SQL**************************************************************************
//    @Modifying
//    @Query(
//            value = "BULK INSERT customer FROM 'C:\\Users\\ishu.thakur\\Downloads\\AddressBook_2022-04-05_12_56_21.csv' WITH ( FIELDTERMINATOR=',' , ROWTERMINATOR='\n' );",
//    nativeQuery = true)
//    void uploadAllFromExcelToDatabase();
}


