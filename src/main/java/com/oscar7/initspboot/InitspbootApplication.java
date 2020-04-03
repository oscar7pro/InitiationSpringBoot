package com.oscar7.initspboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * l'entré d'API
 */
@SpringBootApplication
@ConfigurationPropertiesScan("com.oscar7.initspboot")
@Configuration
public class InitspbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitspbootApplication.class, args);
	}

}
