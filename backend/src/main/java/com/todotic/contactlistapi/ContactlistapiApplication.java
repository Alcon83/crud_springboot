package com.todotic.contactlistapi;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.todotic.contactlistapi.entity.Contact;
import com.todotic.contactlistapi.repository.ContactRepository;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args -> {
			List<Contact> contacts = Arrays.asList(
					// Suponiendo que tu constructor Contact(@NonNull String name, @NonNull String
					// email, @NonNull LocalDateTime createAt) exista
					new Contact("Nombre1", "email@example.com", LocalDateTime.now()),
					new Contact("Nombre2", "email2@example.com", LocalDateTime.now()),
					new Contact("Nombre1", "email@example.com", LocalDateTime.now()),
					new Contact("Nombre2", "email2@example.com", LocalDateTime.now()),
					new Contact("Nombre1", "email@example.com", LocalDateTime.now()),
					new Contact("Nombre2", "email2@example.com", LocalDateTime.now())
			// Añade más instancias de Contact según sea necesario
			);
			contactRepository.saveAll(contacts);
		};
	}
}
