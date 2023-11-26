package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;

public class MyThreads extends Thread{
    public Long countInCircle =0l;
    public Long countNotInCircle=0l;
    Long border;
    public MyThreads(Long border)
    {
        this.border = border;
    }
    @Override
    public void run() {
        Long squareSide = 1000000000l;
        Long radiusCircle = squareSide / 2;
        Long i = 0l;
        while (i < border)
        {
            long x = ThreadLocalRandom.current().nextLong(squareSide);
            long y = ThreadLocalRandom.current().nextLong(squareSide);
            if(x*x + y*y - 2*radiusCircle*(x+y) < -radiusCircle*radiusCircle)
            {
                countInCircle++;
            }
            else
            {
                countNotInCircle++;
            }
            i++;
        }
    }

    Long printInCircle()
    {
        return countInCircle;
    }
    Long printNotInCircle()
    {
        return countNotInCircle++;
    }

}
