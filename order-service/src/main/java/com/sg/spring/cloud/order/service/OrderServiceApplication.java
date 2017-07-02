package com.sg.spring.cloud.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * A sample of a Spring Boot application which:
 *  - retrieves it's configuration from a Spring Cloud server, on startup
 *  - registers itself in a discovery server (Eureka) server
 *
 * @author bogdan.solga
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}
