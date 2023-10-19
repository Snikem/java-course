package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class Task8 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task8() {
    }

    public static boolean isOutOfBorders(int i, int j) {
        if (i < 0 || i > 7 || j < 0 || j > 7) {
            return true;
        }
        return false;
    }

    public static boolean knightBoardCapture(int[][] arr) {
        int[] shifts = new int[] {2, 1, 2, -1, -2, 1, -2, -1, 1, 2, 1, -2, -1, 2, -1, -2};
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                for (int g = 0; g < 8; g += 2) {
                    if (!isOutOfBorders(i + shifts[g], j + shifts[g + 1])) {
                        if (arr[i + shifts[g]][j + shifts[g + 1]] == 1) {
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

}
