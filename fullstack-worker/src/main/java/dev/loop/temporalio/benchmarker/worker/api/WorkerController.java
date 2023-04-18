package dev.loop.temporalio.benchmarker.worker.api;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkInput;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkResult;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkerWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.common.RetryOptions;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class WorkerController {

    WorkflowClient client;

    public WorkerController(WorkflowClient client) {
        this.client = client;
    }

    WorkflowOptions options;

    @Value("${BENCHMARKER_TASKQUEUE:default}")
    public void initOptions(String taskQueue) {
        this.options = WorkflowOptions.newBuilder()
                .setTaskQueue(taskQueue)
                .setWorkflowExecutionTimeout(Duration.ofMinutes(1))
                .setRetryOptions(RetryOptions
                        .newBuilder()
                        .setMaximumAttempts(3)
                        .build())
                .build();
    }

    @PostMapping("/benchmarker")
    public Mono<BenchmarkResult> getBenchmarker(@RequestBody BenchmarkInput body) {
        BenchmarkerWorkflow wf = client.newWorkflowStub(BenchmarkerWorkflow.class, options);
        return Mono.fromFuture(WorkflowClient.execute(wf::benchmark, body));
    }

}
