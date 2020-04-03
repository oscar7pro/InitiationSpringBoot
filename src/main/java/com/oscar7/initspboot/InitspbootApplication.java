package com.oscar7.initspboot;

import com.oscar7.initspboot.repository.ProductRepository;
import org.apache.catalina.core.ApplicationPart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * l'entré d'API
 */
@SpringBootApplication
public class InitspbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitspbootApplication.class, args);
	}

}
