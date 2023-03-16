package dev.loop.temporalio.benchmarker.activityworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ActivityWorkerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ActivityWorkerApplication.class, args);
		context.start();
	}

}
