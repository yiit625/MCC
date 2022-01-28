package com.bank.MCC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication(scanBasePackages={"com.bank.MCC.entities"})
@EnableJpaRepositories(basePackages = {"com.bank.MCC.repositories"})
@EntityScan("com.bank.*")
public class MccApplication {

	public static void main(String[] args) {
		SpringApplication.run(MccApplication.class, args);
	}

}
