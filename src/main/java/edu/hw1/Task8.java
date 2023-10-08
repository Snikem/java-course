package edu.hw1;

import java.io.IOException;

public class Task8 {
   public static boolean knightBoardCapture(int[][] arr)
   {
       int[] shifts = new int[]{2,1,2,-1,-2,1,-2,-1,1,2,1,-2,-1,2,-1,-2};
       int len = arr.length;
       for(int i = 0; i < len;i++)
       {
           for(int j = 0; j < len;j++)
           {
               if(arr[i][j] == 0)
               {
                   continue;
               }
               for(int g = 0; g < 8;g+=2)
               {
                   try{
                       if(arr[i + shifts[g]][j + shifts[g+1]] == 1)
                       {
                           return false;
                       }
                   }catch (ArrayIndexOutOfBoundsException exception)
                   {
                       continue;
                   }

               }
           }
       }
       return true;
   }


    public static void main(String[] args)
    {
        int[][] a1 = new int[][]{
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        int[][] a2 = new int[][]{
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        int[][] a3 = new int[][]{
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(knightBoardCapture(a3));

    }

}
