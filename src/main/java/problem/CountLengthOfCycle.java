package problem;

import java.util.*;

public class CountLengthOfCycle {

    /**
     *
     * You have an integer array.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     *
     */
    public static int countLengthOfCycle( int[] arr, int startIndex ) {
           Set<Integer> set = new HashSet<>();
           int val = arr[startIndex];
           set.add(val);
           boolean flag = false;
           for(;val<arr.length;){
               val = arr[val];
               if(set.contains(val)){
                   flag = true;
                   break;
               }else{
                   set.add(val);
               }
           }
           if(flag){
               return set.size();
           }else{
               return -1;
           }
        }



    public static void main( String[] args ) {

        boolean testsPassed = true;

        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;

        if(testsPassed) {
            System.out.println( "Test passed." );
            //return true;
        } else {
            System.out.println( "Test failed." );
            //return false;
        }


    }
}
