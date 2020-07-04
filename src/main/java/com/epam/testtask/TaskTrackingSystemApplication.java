package com.epam.testtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TaskTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackingSystemApplication.class, args);
		openHomePage();
	}

	private static void openHomePage() {
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
