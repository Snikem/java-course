package edu.hw1;

public class Task4 {

    public static String fixString(String str) {
        String result = "";
        for (int i = 1; i < str.length(); i += 2) {
            result += str.substring(i, i + 1) + str.substring(i - 1, i);
        }
        if (str.length() % 2 == 1) {
            result += str.substring(str.length() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fixString("badce"));

    }
}
