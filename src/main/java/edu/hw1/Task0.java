package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"uncommentedmain", "LineLength"})
public class Task0 {
    private final static Logger LOGGER = LogManager.getLogger();
// это вроде задание под номером ноль, не совсем понимаю где нужно убрать лишний код.

    private Task0() {
    }

    public static void main(String[] args) {
        LOGGER.info("Привет, мир!");
    }
}
