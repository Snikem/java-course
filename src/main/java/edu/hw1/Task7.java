package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"uncommentedmain", "MagicNumber"})
public class Task7 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task7() {
    }

    static int rotateLeft(int n, int shift) {
        String str = Integer.toBinaryString(n);
        str = str.substring(shift) + str.substring(0, shift);
        return Integer.parseInt(str, 2);
    }

    static int rotateRight(int n, int shift) {
        String str = Integer.toBinaryString(n);
        str = str.substring(str.length() - shift) + str.substring(0, str.length() - shift);
        return Integer.parseInt(str, 2);

    }

    public static void main(String[] args) {
        LOGGER.info(rotateLeft(17, 2));

    }
}
