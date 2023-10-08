package edu.hw1;

public class Task7 {


    static int rotateLeft(int n, int shift)
    {
        String str = Integer.toBinaryString(n);
        str = str.substring(shift) + str.substring(0,shift);
        return Integer.parseInt(str,2);
    }
    static int  rotateRight(int n, int shift)
    {
        String str = Integer.toBinaryString(n);
        str = str.substring(str.length() - shift) + str.substring(0,str.length() - shift);
        return Integer.parseInt(str,2);

    }
    public static void main(String[] args)
    {
        System.out.println(rotateLeft(17, 2));

    }
}
