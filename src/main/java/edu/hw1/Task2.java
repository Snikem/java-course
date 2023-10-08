package edu.hw1;

public class Task2 {

    public static int countDigits(int n) {
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
        System.out.println(countDigits(4666));
    }
}
