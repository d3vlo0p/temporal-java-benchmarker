package dev.loop.temporalio.benchmarker.workflowworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableConfigurationProperties(BenchmarkerConfig.class)
public class WorkflowWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowWorkerApplication.class, args);
	}

	// @Bean
	// public WorkerFactoryStarter workerFactoryStarter(WorkerFactory workerFactory, BenchmarkerConfig config) {
	// 	Worker w = workerFactory.newWorker(config.getTaskQueue(), WorkerOptions.newBuilder()
	// 			.setMaxConcurrentWorkflowTaskPollers(config.getPollers())
	// 			.setMaxConcurrentWorkflowTaskExecutionSize(config.getExecutors())
	// 			.validateAndBuildWithDefaults());
	// 	w.registerWorkflowImplementationTypes(BenchmarkerWorkflowImpl.class);
	// 	return new WorkerFactoryStarter(workerFactory);
	// }

}
