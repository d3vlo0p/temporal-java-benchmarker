package dev.loop.temporalio.benchmarker;

import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkInput;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkResult;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkerWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class App {

    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);

        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue("default")
                .build();
        BenchmarkerWorkflow workflow;
        for (int i = 0; i < 10; i++) {
            workflow = client.newWorkflowStub(BenchmarkerWorkflow.class, options);
            BenchmarkResult r = workflow.benchmark(new BenchmarkInput(2L, 10L, 200L));
            System.out.printf("Benchmark Execution n.%d : %s%n", i, r.toString());
        }
    }

}
