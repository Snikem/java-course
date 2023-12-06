package edu.hw9.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StatsCollector implements AutoCloseable {
    private final List<MyData> myData = Collections.synchronizedList(new ArrayList<>());
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void push(String metricName, double[] data) {
        executorService.execute(() -> aggregate(metricName, data));
    }

    private void aggregate(String metricName, double[] data) {
        double val = switch (metricName) {
            case "sum" -> Arrays.stream(data).sum();
            case "average" -> Arrays.stream(data).average().orElse(0);
            case "max" -> Arrays.stream(data).max().orElse(Double.MIN_VALUE);
            case "min" -> Arrays.stream(data).min().orElse(Double.MAX_VALUE);
            default -> throw new IllegalArgumentException();
        };
        myData.add(new MyData(metricName, val));
    }

    public List<MyData> stats() {
        return myData;
    }

    @SuppressWarnings("MagicNumber")
    @Override
    public void close() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
