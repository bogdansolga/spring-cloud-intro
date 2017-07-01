package com.sg.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * A small Spring Boot demo for demoing the usage of a Spring Cloud config server
 *
 * @author bogdan.solga
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		// There is a "native" profile in the Config Server that doesn't use Git,
		// but loads the config files from the file system
		System.setProperty("spring.profiles.active", "native");

		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
