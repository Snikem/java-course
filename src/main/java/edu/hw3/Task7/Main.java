package edu.hw3.Task7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args)
    {
        TreeMap<String, String> tree = new TreeMap<String, String>(Comparator.nullsFirst(Comparator.naturalOrder()));
        tree.put(null,"asd");
        LOGGER.info(tree.containsKey(null));
    }
}
