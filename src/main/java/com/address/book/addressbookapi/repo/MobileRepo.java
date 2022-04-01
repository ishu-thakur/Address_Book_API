package com.address.book.addressbookapi.repo;

import com.address.book.addressbookapi.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepo extends JpaRepository<Mobile,Long> {
}
