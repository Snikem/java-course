package edu.hw7.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PiValue {
    int accuracy;
    private final static Logger LOGGER = LogManager.getLogger();
    Long squareSide = 1000000000l;
   ThreadLocalRandom tl = ThreadLocalRandom.current();

    AtomicInteger notInCircle = new AtomicInteger();
    AtomicInteger inCircle = new AtomicInteger();
    Long notInCircleL= 0l;
    Long inCircleL= 0l;
    Long radiusInSquare;
    Long radiusCircle;

    public PiValue()
    {
        radiusCircle = squareSide / 2;
        radiusInSquare = (radiusCircle) * (radiusCircle);

    }
    public void putPoint()
    {
        Long squareSide = 1000000000l;
        Long radiusCircle = squareSide / 2;
        long x = tl.nextLong(squareSide);
        long y = tl.nextLong(squareSide);
        if(x*x + y*y - 2*radiusCircle*(x+y) < -radiusCircle*radiusCircle)
        {
            inCircle.incrementAndGet();
        }
        else
        {
            notInCircle.incrementAndGet();


        }

    }
    public double calculationPiParallel(Long accuracy, int numberOfThreads)
    {
        MyThreads[] threads = new MyThreads[numberOfThreads];
        Long border = accuracy/ numberOfThreads;
        for(int i = 0; i < numberOfThreads;i++)
        {
            threads[i] = new MyThreads(border);
            threads[i].start();
        }
        for(int i = 0; i < numberOfThreads;i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for(int i = 0; i < numberOfThreads;i++)
        {
            inCircleL = threads[i].countInCircle;
            notInCircleL = threads[i].countNotInCircle;
        }

        return 4 * Double.valueOf(inCircleL) / Double.valueOf(inCircleL + notInCircleL);
    }

    public double calculationPi(int accuracy)
    {
        for(int i = 0; i < accuracy;i++)
        {
            putPoint();
        }
        return 4 * Double.valueOf(inCircle.get()) / Double.valueOf(inCircle.get() + notInCircle.get());
    }


}
