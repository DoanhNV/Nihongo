package com.nihongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author DoanhNV Jul 7, 2018 10:35:17 AM
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}

}
