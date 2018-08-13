package com.bridgelabz.fundoonotes.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FundoonotesNotesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundoonotesNotesMicroserviceApplication.class, args);
	}
}
