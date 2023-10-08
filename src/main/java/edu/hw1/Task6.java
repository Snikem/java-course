package edu.hw1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task6 {

    public static int countK(int n, int count)
    {
        if(n == 6174)
        {
            return count;
        }
        int[] arr = new int[]{n / 1000,n % 1000 / 100,n % 100 / 10, n % 10};
        Arrays.sort(arr);
        int toMin = 0;
        int toMax = 0;
        for(int i = 0; i < 4;i++)
        {

            toMax+= Math.pow(10,i) * arr[i];
            toMin+= Math.pow(10,3 - i) * arr[i];
        }
        //System.out.println(toMax+" - "+toMin+" = "+(toMax-toMin));
        count++;
        return countK(toMax - toMin,count);
    }

    public static void main(String[] args)
    {
        System.out.println(countK(2195,0));

    }
}
