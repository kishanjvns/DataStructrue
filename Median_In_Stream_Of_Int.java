package org.example.prep.gs;

import java.util.Arrays;

public class Median_In_Stream_Of_Int {
    public static void main(String[] args) {
        printMedian(new int[]{ 5, 15});
    }
    public static void printMedian(int arr[]){
        Arrays.sort(arr);
        int mid = arr.length/2;
        if(arr.length%2 ==0){
            //even case
            int avg = (arr[mid-1] + arr[mid]) / 2;
            System.out.println(avg);
        }else{
            //odd case
            System.out.println(arr[mid]);
            return;
        }
    }
}
