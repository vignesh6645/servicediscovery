package com.example.workerDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
@EnableDiscoveryClient
public class WorkerDetailsApplication {


	public static void main(String[] args) {
		SpringApplication.run(WorkerDetailsApplication.class, args);
	}

}
