package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"uncommentedmain", "MagicNumber"})
public class Task4 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task4() {
    }

    public static String fixString(String str) {
        String result = "";
        for (int i = 1; i < str.length(); i += 2) {
            result += str.substring(i, i + 1) + str.substring(i - 1, i);
        }
        if (str.length() % 2 == 1) {
            result += str.substring(str.length() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LOGGER.info(fixString("badce"));

    }
}
