package org.example.prep.gs;

import java.util.HashMap;

public class Dictionary {
    private static void getLargestWordFromDictionary(String[] array, String input){

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String resultString = "";
        for (Character c: input.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }
        for (String word: array){
            if(word.length() < input.length()){
                continue;
            }
            char[] worArr = word.toCharArray();
            boolean isMatched = true;
            for(char ch: worArr){
                if(frequencyMap.containsKey(ch)){
                    continue;
                }
                isMatched = false;
                break;
            }
            if(isMatched){
                if(word.length() > resultString.length()){
                    resultString = word;
                }
            }
        }
        System.out.println(resultString);
    }
    public static void main(String[] args) {
        String[] array = {"to","toes","toe","eottoe","toto"};
        String input = "toe";
        getLargestWordFromDictionary(array, input);

    }
}
