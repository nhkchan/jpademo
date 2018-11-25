package com.example.nhkchanjpa.jpademo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(PeopleRepository repository) {
		return (args) -> {
			// save a couple of Peoples
			/*
			repository.save(new People(2,"Jack", "Bauer"));
			repository.save(new People(3,"Chloe", "O'Brian"));
			repository.save(new People(4,"Kim", "Bauer"));
			repository.save(new People(5,"David", "Palmer"));
			repository.save(new People(6,"Michelle", "Dessler"));
			*/

			// fetch all Peoples
			log.info("Peoples found with findAll():");
			log.info("-------------------------------");
			for (People People : repository.findAll()) {
				log.info(People.toString());
			}
			log.info("");

			// fetch an individual People by ID
			repository.findById(1L)
				.ifPresent(People -> {
					log.info("People found with findById(1L):");
					log.info("--------------------------------");
					log.info(People.toString());
					log.info("");
				});

			// fetch Peoples by last name
			log.info("People found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLname("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			
			log.info("Custom query start: ");
			log.info("--------------------------------------------");
			log.info(repository.find("Palmer").toString());
			// for (People bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}