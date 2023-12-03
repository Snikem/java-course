package edu.hw8.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"UncommentedMain", "MagicNumber"})
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadPool threadPool = new MyThreadPool(6);
        Fibonacci counter = new Fibonacci();

        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futures.add(
                CompletableFuture.supplyAsync(
                    () -> counter.count(10),
                    threadPool
                ));
        }

        for (Future<Integer> future : futures) {
            LOGGER.info(future.get());
        }

        threadPool.shutdown();
    }
}
