package com.address.book.addressbookapi.repo;

import com.address.book.addressbookapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstName(String firstName);
}


