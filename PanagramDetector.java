package org.example.prep.gs;

import java.util.Arrays;

public class PanagramDetector {
        private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        public String findMissingLetters(String sentence) {

            int[] alphaPosArr =new int[26];
            char[] arr = sentence.toLowerCase().toCharArray();
            for(char ch: arr){
                if(ch == ' '){
                    continue;
                }
                int idx = ((int) ch) -'a';
                if(alphaPosArr[idx] > 0){
                    alphaPosArr[idx] = alphaPosArr[idx]++;
                }
                alphaPosArr[idx] = 1;
            }
            String res="";
            for(int i=0;i < alphaPosArr.length;i++){
                if(alphaPosArr[i] == 0){
                    //found missing
                    char ch = (char) ((char) i+97);
                    res+=ch;
                }
            }
            return res;
        }

    public static void main(String[] args) {
        PanagramDetector pd= new PanagramDetector();
        boolean success = true;

        success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
        success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

        if (success) {
            System.out.println("Pass ");
        } else {
            System.out.println("Failed");
        }
    }
}
