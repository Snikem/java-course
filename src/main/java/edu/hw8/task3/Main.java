package edu.hw8.task3;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"UncommentedMain", "MagicNumber", "UnusedImports"})
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args)
        throws UnsupportedEncodingException, NoSuchAlgorithmException, InterruptedException, ExecutionException {
        MD5Cash cash = new MD5Cash();
        cash.creatPasswords();
        /*  GuessingPassword guessingPassword = new GuessingPassword();
        String s = "dcddb75469b4b4875094e14561e573d8";
        ExecutorService executorService = Executors.newFixedThreadPool(12);

        Callable<String> callable = () -> {
            return guessingPassword.guessing(cash, s);
        };
        var tasks = Stream.generate(() -> callable).limit(12).toList();
        long start = System.nanoTime();
        List<Future<String>> futures = executorService.invokeAll(tasks);
        for (var future : futures) {
            LOGGER.info(future.get());
        }
        long end = System.nanoTime();
        LOGGER.info("time: " + (end - start) / (1000_000_000));
        executorService.shutdown(); */

    }
}
