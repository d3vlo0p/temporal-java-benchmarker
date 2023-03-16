package dev.loop.temporalio.benchmarker.workflowworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WorkflowWorkerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WorkflowWorkerApplication.class, args);
		context.start();
	}

}
