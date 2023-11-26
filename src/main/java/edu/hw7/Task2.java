package edu.hw7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task2 {
    //Реализуйте функцию, которая вычисляет факториал числа в многопоточном режиме при помощи parallelStream.
    private final static Logger LOGGER = LogManager.getLogger();
    public static int factorial(int n)
    {
        List<Integer> list = IntStream.rangeClosed(1,n).boxed().toList();
        return list.parallelStream().reduce((x,y) -> x*y).get();
    }
    public static void main(String[] args)
    {
        LOGGER.info(factorial(5));
    }
}
