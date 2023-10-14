package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class Task3 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task3() {
    }

    public static int minInArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < result) {
                result = arr[i];
            }
        }
        return result;
    }

    public static int maxInArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > result) {
                result = arr[i];
            }
        }
        return result;
    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        int maxAr1 = maxInArray(arr1);
        int maxAr2 = maxInArray(arr2);
        int minAr1 = minInArray(arr1);
        int minAr2 = minInArray(arr2);
        if ((minAr1 > minAr2) && (maxAr1 < maxAr2)) {
            return true;
        }
        return false;
    }
}
