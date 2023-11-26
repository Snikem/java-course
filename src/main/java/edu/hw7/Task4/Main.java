package edu.hw7.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args)
    {
        PiValue piValue = new PiValue();
        long start = System.currentTimeMillis();
        LOGGER.info(piValue.calculationPiParallel(1_000_000_000l,12));
        long end = System.currentTimeMillis();
        LOGGER.info((end - start)*0.001+" Секунд");

    }
}
