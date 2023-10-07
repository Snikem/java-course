package edu.hw1;

public class Task5 {


    public static boolean isPalindrome(int n)
    {
       String str_n = String.valueOf(n);
       StringBuilder sb =new StringBuilder(str_n);
       sb.reverse();
       String str_n_reverse = sb.toString();
       return str_n_reverse.equals(str_n);
    }
    public static int toDescendant(int n)
    {
        int result = 0;
        int i = 0;
        while (n != 0)
        {
            result +=(n % 10 + (n % 100 / 10)) * Math.pow(10,i);
            n/=100;
            i++;
        }
        return result;
    }

    public static boolean isPalindromeDescendantRecurse(int n)
    {
        if(String.valueOf(n).length() <= 1)
        {
            return false;
        }
        if(isPalindrome(n))
        {
            return true;
        }
        return isPalindromeDescendantRecurse(toDescendant(n));

    }

    public static boolean isPalindromeDescendant(int n)
    {
        if(String.valueOf(n).length() % 2 == 1)
        {
            n*=10;
        }
        return isPalindromeDescendantRecurse(n);
    }
    public static void main(String[] args)
    {
        System.out.println(isPalindromeDescendant(220));
    }
}
