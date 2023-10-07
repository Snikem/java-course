package edu.hw1;

public class Task3 {
    public static int min_in_array(int[] arr)
    {
        int result = arr[0];
        for(int i = 1; i < arr.length;i++)
        {
            if(arr[i] < result)
            {
                result = arr[i];
            }
        }
        return result;
    }
    public static int max_in_array(int[] arr)
    {
        int result = arr[0];
        for(int i = 1; i < arr.length;i++)
        {
            if(arr[i] > result)
            {
                result = arr[i];
            }
        }
        return result;
    }

    public static boolean isNestable(int[] arr1, int[] arr2)
    {
        int max_ar1 = max_in_array(arr1);
        int max_ar2 = max_in_array(arr2);
        int min_ar1 = min_in_array(arr1);
        int min_ar2 = min_in_array(arr2);
        if((min_ar1 > min_ar2) && (max_ar1 < max_ar2))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{2, 3};
        System.out.println(isNestable(a1,a2));

    }
}
