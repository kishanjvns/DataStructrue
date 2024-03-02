package org.example.prep.gs;

public class SecondSmallest {
    public static int secondSmallest(int[] x) {
        if(x.length<=1){
            return x[0];
        }
        int minIdx = x[0];
        int min = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;
        for(int i=0;i<x.length;i++){
            if(x[i] < min){
                sMin = min;
                min =x[i];
            }
            if(x[i] > min && x[i] < sMin){
                sMin=x[i];
            }
        }
        return sMin;
    }

    public static void main(String args[]) {

        int[] aa={1,2,3,4,5};
        int[] a = { 0 };
        int[] b = { 0, 1 };

        boolean result = true;
        result &= secondSmallest(aa) == 2;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }
}
