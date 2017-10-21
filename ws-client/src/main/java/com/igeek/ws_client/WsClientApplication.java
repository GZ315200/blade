package com.igeek.ws_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author mazean
 */
@SpringBootApplication
public class WsClientApplication {

	public static Logger LOGGER = LoggerFactory.getLogger(WsClientApplication.class);


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WsClientApplication.class, args);
		LOGGER.info("=======================================================================");

		LOGGER.info("current env " + Arrays.toString(context.getEnvironment().getActiveProfiles()));
		LOGGER.info("application name: " + context.getApplicationName());
		LOGGER.info("start time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(context.getStartupDate()));
		LOGGER.info("=======================================================================");

	}
}
