package edu.hw2.task4;

public record CallingInfo(String className, String methodName) {
    @Override public String className() {
        return className;
    }

    @Override public String methodName() {
        return methodName;
    }
}
