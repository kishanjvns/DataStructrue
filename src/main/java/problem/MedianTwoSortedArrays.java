package problem;

import java.util.Arrays;

public class MedianTwoSortedArrays {
    public static double logic(int[] a, int[] b) {
        //array are sorted, first merge them
        int[] newArr = new int[a.length+b.length];
        int i =0;
        int j=0;
        int k=0;
        while ( i < a.length && j < b.length){
            if(a[i] < b[j]){
                newArr[k] = a[i];
                k++;
                i++;
            }else{
                newArr[k] = b[j];
                j++;
                k++;
            }
        }
        while (i < a.length){
            newArr[k] = a[i];
            i++;
            k++;
        }while (j < b.length){
            newArr[k] = b[j];
            j++;
            k++;
        }
        int mid = newArr.length/2;
        float res = -1;
        if(newArr.length%2 ==0){
            //even
            res = (float)(newArr[mid-1] + newArr[mid]) / 2;
        }else{
            //odd
            res = newArr[mid];
        }
        return res;
    }

    public static boolean pass()
    {
        boolean result = true;
        result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
        return result;
    };

    public static void main(String[] args)
    {
        if(pass())
        {
            System.out.println("pass");
        }
        else
        {
            System.out.println("some failures");
        }
    }
}
