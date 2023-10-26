package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private final static Logger LOGGER = LogManager.getLogger();
    static List<String>  clusterize(String input)
    {
        List<String> result = new ArrayList<String>();
        String temp = "";
        int counter = 0;
        for(int i = 0;i < input.length();i++)
        {
            temp+=input.charAt(i);
            if(input.charAt(i)==')')
            {
                counter--;
            }
            if(input.charAt(i)=='(')
            {
                counter++;
            }
            if(counter==0)
            {
                result.add(temp);
                temp = "";
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        LOGGER.info(clusterize("((())())(()(()()))").toString());
    }

}
