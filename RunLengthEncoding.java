package org.example.prep.gs;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RunLengthEncoding {
    public static String rle(String input) {
        HashMap<Character,Integer> map=new LinkedHashMap<>();
        for(char ch: input.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        String result="";
        for(char key:map.keySet()){
            result=key+""+map.get(key)+result;
        }
        return result;
    }
    public static String rle2(String input) {
        StringBuilder result=new StringBuilder();
        int count=1;
        for(int i=1; i<input.length(); i++){
            if(input.charAt(i-1)==input.charAt(i)){
                count++;
                continue;
            }
            result.append(input.charAt(i)+""+count);
            count=0;
        }
        result.append(input.charAt(input.length() - 1)+""+count);
        return  result.toString();
    }


    public static void main(String[] args)  {
        if("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "a3".equals(rle("aaa"))){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }
}
