package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    public static String atbash(String input) {
        int a = 'a';
        int z = 'z';
        int capitalA = 'A';
        int capitalZ = 'Z';
        int inputChar = 0;
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            inputChar = (int) input.charAt(i);

            if (inputChar >= a && inputChar <= z) {
                result = result + (char) (-inputChar + a + z);
                continue;
            }
            if (inputChar >= capitalA && inputChar <= capitalZ) {
                result = result + (char) (-inputChar + capitalA + capitalZ);
                continue;
            }
            result += (char) inputChar;
        }
        return result;

    }

}
