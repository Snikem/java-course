package edu.hw2.task4;

import java.util.Arrays;

public class Task4 {
    public CallingInfo callingInfo() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        CallingInfo callingInfo = new CallingInfo(
            Arrays.stream(stackTraceElements).toList().get(2).getClassName(),
            Arrays.stream(stackTraceElements).toList().get(2).getMethodName()
        );
        return callingInfo;
    }
}
