package dev.loop.temporalio.benchmarker.workflowworker.workflow;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivity;
import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivityInput;
import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivityResult;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkInput;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkResult;
import dev.loop.temporalio.benchmarker.commons.workflow.BenchmarkerWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

public class BenchmarkerWorkflowImpl implements BenchmarkerWorkflow {

    BenchmarkActivity activity = Workflow.newActivityStub(BenchmarkActivity.class,
            ActivityOptions.newBuilder()
                    .setTaskQueue(ActivityConfiguration.getTaskQueue())
                    .setStartToCloseTimeout(Duration.ofSeconds(10))
                    .setRetryOptions(RetryOptions.newBuilder()
                            .setMaximumAttempts(3)
                            .build())
                    .build());

    @Override
    public BenchmarkResult benchmark(BenchmarkInput input) {
        List<BenchmarkActivityResult> results = new LinkedList<>();
        for (int i = 0; i < input.iterations(); i++) {
            results.add(activity
                    .benchmark(new BenchmarkActivityInput(input.minDurationInMillis(), input.maxDurationInMillis())));
        }
        return new BenchmarkResult(results);
    }

}
