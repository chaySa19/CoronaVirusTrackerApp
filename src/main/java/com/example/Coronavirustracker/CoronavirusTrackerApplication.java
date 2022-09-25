package com.example.Coronavirustracker;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CoronavirusTrackerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(CoronavirusTrackerApplication.class, args);
		//new CoronaVirusDataService().fetchVirusData();
	}

}
