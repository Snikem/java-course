package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class Task6 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

    public static boolean compareFourNum(int a, int b, int c, int d) {
        if (a == b) {
            if (a == c) {
                if (a == d) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int countKRecurse(int n, int count) {
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
        myCount++;
        return countKRecurse(toMax - toMin, myCount);
    }

    public static int countK(int n, int count) {
        if (n <= 1000 || n >= 9999) {
            return -1;
        }
        if (compareFourNum(n / 1000, n % 1000 / 100, n % 100 / 10, n % 10)) {
            return -1;
        }
        return countKRecurse(n, count);
    }

}
