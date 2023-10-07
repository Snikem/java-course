package edu.hw1;

public class Task1 {

    public static int minutesToSeconds(String time)
    {
        int len_str = time.length();
        int min = Integer.valueOf(time.substring(0,len_str - 3));
        int sec = Integer.valueOf(time.substring(len_str - 2,len_str));
        if(sec >= 60)
        {
            return -1;
        }

        return 60 * min + sec;
    }
    public static void main(String[] args) {
      System.out.println(minutesToSeconds("13:56"));
    }
}
