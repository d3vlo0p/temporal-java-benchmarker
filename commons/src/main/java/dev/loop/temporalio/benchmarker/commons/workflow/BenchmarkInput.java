package dev.loop.temporalio.benchmarker.commons.workflow;

public record BenchmarkInput(Long iterations, Long minDurationInMillis, Long maxDurationInMillis) {

}
