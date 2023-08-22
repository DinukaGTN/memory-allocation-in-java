package com.gtngroup.memtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MemoryTrackingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MemoryTrackingApplication.class, args);

		MemoryTracker memoryTracker = context.getBean(MemoryTracker.class);
		memoryTracker.trackMemoryUsage();
	}
}
