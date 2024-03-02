package org.example.prep.gs;

public class PoweOf10 {
    public static void main(String[] args) {
        PoweOf10 m = new PoweOf10();
        //System.out.println(m.isPowerOf10(103));
    }
    public boolean isPowerOf10(int n) {
        if(n==0)
            return false;
        while(n%10==0){
            n/=10;
        }
        boolean flag = n==1;
        return flag;
    }

}
