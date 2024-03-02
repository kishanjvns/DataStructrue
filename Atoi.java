package org.example.prep.gs;

public class Atoi {
    public static int atoi(String str)
    {
        String res="0";
        if(str.isEmpty()){
            return Integer.parseInt(res);
        }
        boolean isNegative= false;
        if(str.startsWith("-")){
            str=str.substring(1);
            isNegative= true;
        }

        for(int i=0; i< str.length(); i++){
          if(Character.isDigit(str.charAt(i))){
              res+=String.valueOf(str.charAt(i));
          }
        }
        if(isNegative){
            res="-"+res;
        }
        return Integer.valueOf(res);
    }

    public static boolean pass()
    {
        boolean result = true;
        result = result && atoi("0") == 0;
        result = result && atoi("1") == 1;
        result = result && atoi("123") == 123;
        result = result && atoi("-1") == -1;
        result = result && atoi("-123") == -123;
        result = result && atoi("123a") == 123;
        result = result && atoi("a") == 0;

        String intMax = String.valueOf(Integer.MAX_VALUE);
        result = result && atoi(intMax) == Integer.MAX_VALUE;

        String intMin = String.valueOf(Integer.MIN_VALUE);
        result = result && atoi(intMin) == Integer.MIN_VALUE;

        return result;
    };

    public static void main(String[] args)
    {
        if(pass())
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Some fail");
        }
    }
}
