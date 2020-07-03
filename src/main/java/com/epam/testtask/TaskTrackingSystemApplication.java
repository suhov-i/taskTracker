package com.epam.testtask;

import com.epam.testtask.formatters.ProjectFormatter;
import com.epam.testtask.formatters.UserFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

//	@Configuration
//	static class MyConfig implements WebMvcConfigurer {
//
//		@Override
//		public void addFormatters(FormatterRegistry registry) {
//			registry.addFormatter(new ProjectFormatter());
//			registry.addFormatter(new UserFormatter());
//		}
//	}
}
