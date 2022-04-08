package com.address.book.addressbookapi;

import com.address.book.addressbookapi.controller.CustomerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class AddressBookApiApplicationTests {

	@Autowired
	private CustomerController customerController;

	@Test
	void contextLoads() throws Exception {
		assertThat(customerController).isNotNull();
	}

}
