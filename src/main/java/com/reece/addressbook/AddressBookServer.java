package com.reece.addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.reece.addressbook.dao.ContactRepository;
import com.reece.addressbook.model.Contact;


@SpringBootApplication
public class AddressBookServer {

	private static final Logger logger = LoggerFactory.getLogger(AddressBookServer.class);
	
    public static void main(String[] args) {
        SpringApplication.run(AddressBookServer.class, args);
    }
    
    

	@Bean
	public CommandLineRunner demo(ContactRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Contact("Jack", "11111"));
			repository.save(new Contact("Chloe", "22222"));
			repository.save(new Contact("Kim", "33333"));

			// fetch all customers
			logger.info("Customers found with findAll():");
			logger.info("-------------------------------");
			for (Contact customer : repository.findAll()) {
				logger.info(customer.toString());
			}
			logger.info("");

			// fetch an individual customer by ID
			Contact customer = repository.findOne(1L);
			logger.info("Customer found with findOne(1L):");
			logger.info("--------------------------------");
			logger.info(customer.toString());
			logger.info("");

			// fetch customers by last name
			logger.info("Customer found with findByLastName('Kim'):");
			logger.info("--------------------------------------------");
			for (Contact bauer : repository.findByName("Kim")) {
				logger.info(bauer.toString());
			}
			logger.info("");
		};
	}
}
