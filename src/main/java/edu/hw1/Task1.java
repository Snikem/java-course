package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"uncommentedmain", "MagicNumber"})
public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    public static int minutesToSeconds(String time) {
        int lenStr = time.length();
        int countDigitSecInInput1 = 3;
        int countDigitSecInInput2 = 2;
        int secInMinutes = 60;
        int min = Integer.valueOf(time.substring(0, lenStr - countDigitSecInInput1));
        int sec = Integer.valueOf(time.substring(lenStr - countDigitSecInInput2, lenStr));
        if (sec >= secInMinutes) {
            return -1;
        }

        return 60 * min + sec;
    }

    public static void main(String[] args) {
        LOGGER.info(minutesToSeconds("13:56"));
    }
}
