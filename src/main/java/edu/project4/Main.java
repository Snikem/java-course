package edu.project4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SuppressWarnings({"MagicNumber"})
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        FractalFlameThread fractalFlameThread = new FractalFlameThread(5, 11, 5);
        long start = System.currentTimeMillis();
        fractalFlameThread.start();
        long end = System.currentTimeMillis();
        LOGGER.info((end - start) * 0.001 + " Секунд");

    }
}
