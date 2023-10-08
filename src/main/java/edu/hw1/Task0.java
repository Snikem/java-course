package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")
public class Task0 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task0() {
    }

    /**
     * Main : Run MapReduce job
     *
     * @param args arguments
     */

    public static void main(String[] args) {
        LOGGER.info("Привет, мир!");
    }
}
