package edu.hw3.Task5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task5 {
    private final static Logger LOGGER = LogManager.getLogger();

    private static String replaseFirstnameLastname(String name) {
        String[] names = name.split(" ");
        if (names.length == 1) {
            return name;
        }
        return names[1] + " " + names[0];
    }

    static List<Contact> parseContacts(List<String> list, String variantSort) {
        if (list == null) {
            return new ArrayList<Contact>();
        }
        List<String> lastnameFirstname = new ArrayList<String>();
        List<Contact> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            lastnameFirstname.add(replaseFirstnameLastname(list.get(i)));
        }
        Collections.sort(lastnameFirstname);
        if (variantSort.equals("DESC")) {
            Collections.reverse(lastnameFirstname);
        }
        for (int i = 0; i < lastnameFirstname.size(); i++) {
            String[] names = lastnameFirstname.get(i).split(" ");
            if (names.length == 1) {
                result.add(new Contact(names[0], ""));
                continue;
            }
            result.add(new Contact(names[1], names[0]));
        }
        return result;

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Paul", "Leonhard Euler", "Carl Gauss"));
        LOGGER.info(parseContacts(list, "DESC"));

    }
}
