package org.example.prep.gs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestUniformString {
    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();
    //
    static int[] longestUniformSubstring(String input){
        if(input.length()<1){
            return new int[]{ -1, 0 };
        }
        int leftWindowIndex = 0;
        int rightWindowIndex = 0;
        int longestWordLength =1;
        int[] resArr = new int[2];
        while (rightWindowIndex < input.length()-1){
            if(input.charAt(rightWindowIndex)== input.charAt(rightWindowIndex+1)){
                rightWindowIndex++;
                continue;
            }
            int diff = rightWindowIndex - (leftWindowIndex);
            if(diff > longestWordLength){
                resArr[0] = leftWindowIndex+1;
                resArr[1] = diff;
                longestWordLength = diff;
            }
            leftWindowIndex = rightWindowIndex;
            rightWindowIndex++;
        }
        // your code goes here
        return resArr;
    }

    public static void main(String[] args) {
        testCases.put("", new int[]{-1, 0});
        testCases.put("abbbccda", new int[]{1, 3});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }
}
