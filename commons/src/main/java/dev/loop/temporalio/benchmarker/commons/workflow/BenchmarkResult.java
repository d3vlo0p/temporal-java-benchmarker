package dev.loop.temporalio.benchmarker.commons.workflow;

import java.util.List;

import dev.loop.temporalio.benchmarker.commons.activity.BenchmarkActivityResult;

public record BenchmarkResult(List<BenchmarkActivityResult> results) {

}
