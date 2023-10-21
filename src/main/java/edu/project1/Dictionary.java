package edu.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber"})
public class Dictionary {
    private final static Logger LOGGER = LogManager.getLogger();

    public String getRandomWord(String path) {
        String line = "";
        int maxCountWords = 7;
        Random random = new Random();
        int quantityWords;
        int leftBoard;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
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
}
