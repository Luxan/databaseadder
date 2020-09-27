package com.decerto.databaseadder;

import com.decerto.databaseadder.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DatabaseadderApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IProcessingService getProcessingService() {
		return new AdditionService();
	}

	@Bean
	public IRandomDataGeneratorService getRandomDataGeneratorService() {
		return new RandomIntegersGeneratorService();
	}

	@Bean
	public IRandomDataRestApiFetchingService getRandomDataApiFetchingService() {
		return new RandomIntegersFromRestApiService();
	}

	@Bean
	public IRandomDataFromDatabaseRetrieverService getRandomDataFromDatabaseRetrieverService() {
		return new RandomIntegersFromDatabaseService();
	}


	public static void main(String[] args) {
		SpringApplication.run(DatabaseadderApplication.class, args);
	}

}
