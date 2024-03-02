package org.example.prep.gs;

public class ReverseString {
    /**
     * public static String reverseStr( String str )
     * Example: reverseStr(str) where str is "abcd" returns "dcba".
     */
    public static String reverseStr( String str ){
        String reversed="";
        for(int i=str.length()-1; i >=0;i--){
            reversed+=str.charAt(i);
        }
        System.out.println(reversed);
        return reversed;
    };


    public static void main(String[] args){

        String testString;
        String solution;
        boolean result = true;

        result = result && reverseStr("abcd").equals("dcba");

        if(result){
            System.out.println("All tests pass");
        }
        else{
            System.out.println("There are test failures");
        }

    }
}
