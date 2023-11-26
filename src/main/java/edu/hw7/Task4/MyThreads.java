package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings({"MagicNumber"})
public class MyThreads extends Thread {
    public Long countInCircle = 0L;
    public Long countNotInCircle = 0L;
    Long border;

    public MyThreads(Long border) {
        this.border = border;
    }

    @Override
    public void run() {
        Long squareSide = 1000000000L;
        Long radiusCircle = squareSide / 2;
        Long i = 0L;
        while (i < border) {
            long x = ThreadLocalRandom.current().nextLong(squareSide);
            long y = ThreadLocalRandom.current().nextLong(squareSide);
            if (x * x + y * y - 2 * radiusCircle * (x + y) < -radiusCircle * radiusCircle) {
                countInCircle++;
            } else {
                countNotInCircle++;
            }
            i++;
        }
    }

}
