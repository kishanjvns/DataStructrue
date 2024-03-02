package org.example.prep.gs;

/*
 **  Below formation is called Pascals Triangle.
 **
 **  Example:
 **               1
 **              1 1
 **             1 2 1
 **            1 3 3 1
 **           1 4 6 4 1
 **         1 5 10 10 5 1
 **        1 6 15 20 15 6 1
 **
 **  Complete the 'pascal' function below so that given a
 **  col and a row it will return the value in that positon.
 **
 **  Example, pascal(1,2) should return 2
 **
 */

public class Pascals {

        public static int pascal(int col, int row) {
            return (int)Math.ceil(findNcr(row,col));
        }
        public static double findNcr(int row,int col){
            double res =1;
            for(int i=0; i< col; i++){
                res = res*(row-i);
                res = res/(i+1);
            }
            return res;
        }
        public static void solve( int col,int row){
            int n = row;
            int r = col;
            int n_r = n-r;
            n=factorial(n);
            r=factorial(r);

            n_r = factorial(n_r);
            int denoMitor = r * n_r;
            int numerator = n;
            int result = numerator/denoMitor;
            System.out.println(result);
        }
    /*nCr = n!/r! * (n-r)!
     * r represent the column
     * n represent the row */

        public static void main(String[] args) {
           solve(4,8);
            if (Pascals.pascal(0, 0) == 1 &&
                    Pascals.pascal(1, 2) == 2 &&
                    Pascals.pascal(5, 6) == 6 &&
                    Pascals.pascal(4, 8) == 70 &&
                    Pascals.pascal(6, 6) == 1) {
                System.out.println("Pass");
            } else {
                System.out.println("Failed");
            }
        }

    public static int factorial(int n){
        int result =1;
        while (n!=0){
            result*=n;
            n--;
        }
        return result;
    }
}
