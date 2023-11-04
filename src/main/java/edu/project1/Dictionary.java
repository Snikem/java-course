package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class Dictionary {
    private final static Logger LOGGER = LogManager.getLogger();

    public String getRandomWordFromFile(String pathInput) {
        String line = "";
        int maxCountWords = 7;
        Random random = new Random();
        int quantityWords;
        int leftBoard;
        String path = "/" + pathInput;
        InputStream is = Dictionary.class.getResourceAsStream(path);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            line = reader.readLine();
            quantityWords = Integer.parseInt(line);
            leftBoard = random.nextInt(1, quantityWords + 1) - 1;
            for (int i = 0; i < leftBoard; i++) {
                reader.readLine();
            }
            line = reader.readLine();
            reader.close();
        } catch (IOException e) {
            LOGGER.info("file not opened");
        }
        if (line.length() > maxCountWords) {
            LOGGER.info("Dictionary is broken");
            System.exit(1);

        }
        LOGGER.info("загаданное слово " + line);
        return line;
    }

    public String getRandomWordFromList() {
        List<String> list = new ArrayList<String>();
        list.add("book");
        list.add("people");
        list.add("job");
        list.add("buffer");
        list.add("hello");
        Random random = new Random();
        return list.get(random.nextInt(0, list.size()));
    }

}
