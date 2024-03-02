package org.example.prep.gs;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MagicPotion {
    /*
Question:
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the
minimum number of characters required to encode

*/
    /*private static int minimalSteps(String ingredients) {
        String encode="";
        int ans=  minimalStepsHelper(ingredients,"");
        return ans;
    }
    private static int minimalStepsHelper(String ingredients,String encoded) {
        if(ingredients.isEmpty()){
            return encoded.length();
        }
        int left=0;
        int right=0;
        String subEncode = "";
        while (right < ingredients.length()){
            String w=String.valueOf(ingredients.charAt(right));
            if(subEncode.contains(w)){
                break;
            }
            subEncode =subEncode.concat(w);
            right++;
        }
        ingredients=ingredients.substring(right);
        if(ingredients.contains(subEncode)){
            ingredients=ingredients.substring(subEncode.length());
            subEncode=subEncode.concat("*");

        }
        return minimalStepsHelper(ingredients,encoded+subEncode);
    }*/

    static int minimalSteps(final String origString) {
        String encoded=origString;
        //encoded string will be the potential answer
        int currentIdx=1;
        int currentNextIdx=0;
        while (currentIdx < origString.length()-1){
            String replaceKey = origString.substring(0,currentIdx+1);
            currentNextIdx = 2 * currentIdx + 1;
            if(currentNextIdx > origString.length()){
                break;
            }
            String temp = origString.substring(currentIdx+1,currentNextIdx+1);
            if(!encoded.contains("*") && temp.equalsIgnoreCase(replaceKey)){
                encoded=encoded.replaceFirst(replaceKey+temp,replaceKey+"*");
                currentIdx=currentNextIdx;
            }else if(temp.equals(replaceKey)){
                encoded=encoded.replaceFirst(replaceKey,"*");
                currentIdx=currentNextIdx;
            }else {
                currentIdx++;
            }
        }

        System.out.println(encoded);
        return encoded.length();


    }
    private static  boolean doTestsPass() {
        return  (minimalSteps("ABABCABABCE")==6 && minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5 );
    }

    public static void main(String[] args) {

        if (doTestsPass() )
        {
            System.out.println("Pass");
        }else
        {
            System.out.println("Fail");
        }
    }
}
