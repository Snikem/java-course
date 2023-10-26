package edu.hw3.Task8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        BackwardIterator it = new BackwardIterator<>(list);
        while(it.hasNext())
        {
            LOGGER.info(it.next());

        }
    }
}
