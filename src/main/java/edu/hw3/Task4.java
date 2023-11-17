package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class Task4 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task4() {
    }

    public static String convertToRoman(int n) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[n / 1000] + hundreds[(n % 1000) / 100] + tens[(n % 100) / 10] + units[n % 10];
    }

}
