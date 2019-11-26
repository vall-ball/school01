package ru.vallball.school01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.vallball.school01")
public class ApplicationConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

}
