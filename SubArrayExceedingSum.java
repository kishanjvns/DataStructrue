package org.example.prep.gs;

import java.util.HashMap;
import java.util.Map;

public class SubArrayExceedingSum {
    public static int subArrayExceedsSum(int arr[], int target )
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < arr.length; i++){
            map.put(arr[i],i);
        }

        for(int i=0; i < arr.length; i++){
            int val = arr[i];
            int sub =  target-val;
            if(map.containsKey(sub)){
                return (map.get(sub) - i);
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        boolean result = true;
        int[] arr = { 1, 2, 3, 4 };
        result = result && subArrayExceedsSum( arr, 6 ) == 2;
        result = result && subArrayExceedsSum( arr, 12 ) == -1;

        if( result )
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
    }
}
