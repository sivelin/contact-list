package com.fhnw.swa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application class to Start the Contact List Application
 * @author Siv Elin Ødegård
 */
@SpringBootApplication
public class ContactsListApplication {

	/**
	 * The main method to start the app
	 * @param args passed to the main method.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ContactsListApplication.class, args);
	}

}
