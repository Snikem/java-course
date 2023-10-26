package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();


    private Task1() {
    }
    public static String atbash(String input) {
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        int input_char = 0;
        String result = "";
        for(int i = 0; i < input.length(); i++)
        {
        input_char = (int)input.charAt(i);

            if(input_char >= a && input_char <=z)
            {
                result = result + (char)(-input_char + a + z);
                continue;
            }
            if(input_char >= A && input_char <=Z)
            {
                result = result + (char)(-input_char + A + Z);
                continue;
            }
            result+=(char)input_char;
        }
        return result;

    }

    public static void main(String[] args) {
        LOGGER.info(atbash("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"));
    }
}
