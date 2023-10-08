package edu.hw1;

public class Task5 {

    public static boolean isPalindrome(int n) {
        String str_n = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str_n);
        sb.reverse();
        String str_n_reverse = sb.toString();
        return str_n_reverse.equals(str_n);
    }

    public static int toDescendant(int n) {
        String result = "";
        int i = 0;
        while (n != 0) {
            result = (n % 10 + (n % 100 / 10)) + result;
            n /= 100;
            i++;
        }
        return Integer.parseInt(result, 10);
    }

    public static boolean isPalindromeDescendant(int n) { // на числа у которых количество цифр нечестное и нет потомков возвращает false
        if (String.valueOf(n).length() <= 1) {
            return false;
        }
        if (isPalindrome(n)) {
            return true;
        }
        if (String.valueOf(n).length() % 2 == 1) {
            return false;
        }
        return isPalindromeDescendant(toDescendant(n));

    }

    public static void main(String[] args) {
        System.out.println(isPalindromeDescendant(123812));
    }
}
