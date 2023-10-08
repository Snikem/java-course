package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SuppressWarnings({"uncommentedmain", "MagicNumber", "ImportOrder"})
public class Task6 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

    public static int countK(int n, int count) {
        int myCount = count;
        if (n == 6174) {
            return myCount;
        }
        int[] arr = new int[] {n / 1000, n % 1000 / 100, n % 100 / 10, n % 10};
        Arrays.sort(arr);
        int toMin = 0;
        int toMax = 0;
        for (int i = 0; i < 4; i++) {

            toMax += Math.pow(10, i) * arr[i];
            toMin += Math.pow(10, 3 - i) * arr[i];
        }
        //System.out.println(toMax+" - "+toMin+" = "+(toMax-toMin));
        myCount++;
        return countK(toMax - toMin, myCount);
    }

    public static void main(String[] args) {
        LOGGER.info(countK(2195, 0));

    }
}
