package edu.hw2;


import edu.hw2.task3.PopularCommandExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        int maxAttempts = 6;
        PopularCommandExecutor executor = new PopularCommandExecutor(maxAttempts);
        executor.updatePackages();
    }
}
