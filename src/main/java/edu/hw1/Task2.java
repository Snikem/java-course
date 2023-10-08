package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"uncommentedmain", "MagicNumber"})
public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    private Task2() {
    }

    public static int countDigits(int num) {
        int n = num;
        int result = 0;
        if (n == 0) {
            return 1;
        }
        while (n != 0) {
            n /= 10;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        LOGGER.info(countDigits(4666));
    }
}
