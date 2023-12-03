package edu.hw8.task2;

public class Fibonacci {
    public int count(int n) {
        if (n > 2) {
            return count(n - 1) + count(n - 2);
        }
        return 1;

    }
}
