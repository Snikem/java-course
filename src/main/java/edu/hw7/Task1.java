package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"UncommentedMain", "MagicNumber"})
public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    public static void main(String[] args) {
        var value = new AtomicInteger();
        Stream.generate(() -> new Thread(new Worker(value))).limit(15).forEach(Thread::start);
    }

    private static class Worker implements Runnable {
        AtomicInteger value;

        private Worker(AtomicInteger value) {
            this.value = value;
        }

        @Override
        public void run() {
            LOGGER.info(value.incrementAndGet() + " potok:" + Thread.currentThread().getName());

        }
    }

}