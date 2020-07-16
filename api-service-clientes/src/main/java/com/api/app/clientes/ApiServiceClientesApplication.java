package com.api.app.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiServiceClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceClientesApplication.class, args);
	}

}
