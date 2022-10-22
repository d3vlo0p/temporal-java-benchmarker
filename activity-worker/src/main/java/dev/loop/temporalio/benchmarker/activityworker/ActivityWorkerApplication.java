package dev.loop.temporalio.benchmarker.activityworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableConfigurationProperties(BenchmarkerConfig.class)
public class ActivityWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityWorkerApplication.class, args);
	}

	// @Bean
	// public Worker createWorkerFactory(BenchmarkerConfig config,
	// 		@Qualifier("BenchmarkActivity") BenchmarkActivityImpl benchmarkActivity) {
	// 	WorkflowServiceStubs service = WorkflowServiceStubs
	// 			.newConnectedServiceStubs(WorkflowServiceStubsOptions.newBuilder()
	// 				.build(), Duration.ofSeconds(10));
	// 	WorkflowClient client = WorkflowClient.newInstance(service);
	// 	WorkerFactory factory = WorkerFactory.newInstance(client);
	// 	Worker w = factory.newWorker(config.getTaskQueue(),
	// 			WorkerOptions.newBuilder()
	// 					.setMaxConcurrentActivityExecutionSize(config.getExecutors())
	// 					.setMaxConcurrentActivityTaskPollers(config.getPollers())
	// 					.validateAndBuildWithDefaults());

	// 	w.registerActivitiesImplementations(benchmarkActivity);

	// 	factory.start();
	// 	return w;
	// }

}
