package org.example.prep.gs;

import java.util.HashSet;

public class UniqueTuples {

        public static HashSet<String> uniqueTuples(String input, int len ) {
            // your code
            HashSet<String> result = new HashSet<String>();
            if(input.length() < len){
                return result;
            }
            String wordWindow = input.substring(0,len);
            result.add(wordWindow);
            char[] chArr = input.toCharArray();
            for(int i=len ; i < chArr.length; i++){
                //remove 1st character from wordWindow and append new char at the end
                wordWindow=wordWindow.substring(1);
                wordWindow+= chArr[i];
                result.add(wordWindow);
            }
            return result;
        }

        public static void main( String[] args ) {
            String input = "aab";
            HashSet<String> result = uniqueTuples( input, 2 );
            if( result.contains( "aa" ) && result.contains( "ab" ) ) {
                System.out.println( "Test passed." );

            } else {
                System.out.println( "Test failed." );

            }
        }
}

