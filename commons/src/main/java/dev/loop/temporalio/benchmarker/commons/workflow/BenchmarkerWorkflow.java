package dev.loop.temporalio.benchmarker.commons.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface BenchmarkerWorkflow {

    @WorkflowMethod
    public BenchmarkResult benchmark(BenchmarkInput input);
    
}
