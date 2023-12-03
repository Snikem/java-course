package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Storage {
    private final static Logger LOGGER = LogManager.getLogger();

    Map<String, String> map = new ConcurrentHashMap<>();

    public Storage() {
        readFile();

    }

    public String getPhrase(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return "error, phrase not found";
    }

    private void readFile() {
        int quantityPhrases;
        String line = "";
        String keyLine = "";
        String valueLine = "";
        String path = "/dict.txt";
        InputStream is = Storage.class.getResourceAsStream(path);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            line = reader.readLine();
            quantityPhrases = Integer.parseInt(line);
            for (int i = 0; i < quantityPhrases; i++) {
                keyLine = reader.readLine();
                valueLine = reader.readLine();
                map.put(keyLine, valueLine);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
