package edu.hw7.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class PiValue {
    private final static Logger LOGGER = LogManager.getLogger();
    Long notInCircleL = 0L;
    Long inCircleL = 0L;

    public PiValue() {

    }

    public double calculationPiParallel(Long accuracy, int numberOfThreads) {
        MyThreads[] threads = new MyThreads[numberOfThreads];
        Long border = accuracy / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new MyThreads(border);
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < numberOfThreads; i++) {
            inCircleL = threads[i].countInCircle;
            notInCircleL = threads[i].countNotInCircle;
        }

        return 4 * Double.valueOf(inCircleL) / Double.valueOf(inCircleL + notInCircleL);
    }

}
