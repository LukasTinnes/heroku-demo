package com.example.demo;

import com.example.demo.classes.Customer;
import com.example.demo.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class DemoApplication {


	private final CustomerRepository repository;

	private final Logger logger = LoggerFactory.getLogger(DemoApplication.class);;

	public DemoApplication(CustomerRepository repository) {
		this.repository = repository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		List allCustomers = this.repository.findAll();
		logger.info("Number of customers: " + allCustomers.size());

		Customer newCustomer = new Customer();
		newCustomer.setFirstName("John");
		newCustomer.setLastName("Doe");
		logger.info("Saving new customer...");
		this.repository.save(newCustomer);

		allCustomers = this.repository.findAll();
		logger.info("Number of customers: " + allCustomers.size());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
