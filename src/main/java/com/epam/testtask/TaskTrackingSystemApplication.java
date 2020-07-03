package com.epam.testtask;

import com.epam.testtask.formatters.ProjectFormatter;
import com.epam.testtask.formatters.UserFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TaskTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackingSystemApplication.class, args);
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
