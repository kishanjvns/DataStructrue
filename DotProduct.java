package org.example.prep.gs;

public class DotProduct {
    /**
     *
     * Given two arrays of integers, returns the dot product of the arrays
     */

    public static int dotProduct( int[] array1, int[] array2 ) {
        if(array1.length == array2.length){
            int productSum=0;
            for(int i=0;i < array1.length; i++){
                productSum+=array1[i] + array2[i];
            }
            return productSum;
        }
        return -1;
    }

    public static void main( String[] args ) {
        int[] array1 = { 1, 2 };
        int[] array2 = { 2, 3 };
        int result = dotProduct( array1, array2 );

        if( result == 8 ) {
            System.out.println( "Passed." );
            return;
        } else {
            System.out.println( "Failed." );
            return ;
        }
    }
}
