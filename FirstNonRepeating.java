package org.example.prep.gs;

import java.util.*;

public class FirstNonRepeating {
    /**
     * Finds the first character that does not repeat anywhere in the input string
     * Given "apple", the answer is "a"
     * Given "racecars", the answer is "e"
     **/
    public static char findFirst(String input) {
        // code goes here
        Map<Character,Integer> map =new LinkedHashMap<>();
        for(char ch: input.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,1)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String args[]) {

        String[] inputs = {"apple", "racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd'};

        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            //System.out.println(findFirst(inputs[i]));
            result = result && findFirst(inputs[i]) == outputs[i];
            if (!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }
}
