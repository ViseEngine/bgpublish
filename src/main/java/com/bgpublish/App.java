package com.bgpublish;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 服务启动类!
 * 
 */
@SpringBootApplication
@ImportResource("classpath:application-context.xml")
public class App {
	private static final Log LOGGER = LogFactory.getLog(App.class);
	
	public static void main(String[] args) {
		LOGGER.info("project starting ==>");
		SpringApplication.run(App.class, args);
	}
}
