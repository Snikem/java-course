package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task3() {
    }

    static <T extends Object> Map<T, Integer> freqDict(List<T> list) {
        Map<T, Integer> result = new HashMap<T, Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (result.containsKey(list.get(i))) {
                result.put(list.get(i), result.get(list.get(i)) + 1);
            } else {
                result.put(list.get(i), 1);
            }
        }
        return result;
    }

}
