package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class Task5 {

    private final static Logger LOGGER = LogManager.getLogger();

    private Task5() {
    }

    public static boolean isPalindrome(int n) {
        String strN = String.valueOf(n);
        StringBuilder sb = new StringBuilder(strN);
        sb.reverse();
        String strNReverse = sb.toString();
        return strNReverse.equals(strN);
    }

    public static int toDescendant(int num) {
        int n = num;
        String result = "";
        while (n != 0) {
            result = (n % 10 + (n % 100 / 10)) + result;
            n /= 100;
        }
        return Integer.parseInt(result, 10);
    }

    public static boolean isPalindromeDescendant(int n) {
        if (String.valueOf(n).length() <= 1) {
            return false;
        }
        if (isPalindrome(n)) {
            return true;
        }
        if (String.valueOf(n).length() % 2 == 1) {
            return false;
        }
        return isPalindromeDescendant(toDescendant(n));

    }
}
