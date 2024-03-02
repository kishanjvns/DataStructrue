package org.example.prep.gs;

public class BinaryAlternateFlipCount {
    public static void main(String[] args) {
        String str = "001";
        BinaryAlternateFlipCount m = new BinaryAlternateFlipCount();
        System.out.println(m.flipCount(str));
    }
    public int flipCount(String str){
        char[] arr = str.toCharArray();
        int count =0;
        char ch = arr[0];
        for(int i=1;i < arr.length; i++){
            if(arr[i] == arr[i-1]){
                count++;
                arr[i] = arr[i]=='0' ?'1':'0';
            }
        }
        return count;
    }

}
