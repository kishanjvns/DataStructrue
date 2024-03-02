package org.example.prep.gs;

import java.util.Arrays;

public class Robot_Movement {

    public static Integer[] walk( String path ) {
        Integer[] res = {0,0};
        int leftCount =0;
        int rightCount =0;
        int upCount =0;
        int downCount =0;
        for(char direction: path.toCharArray()){
            int v1 = res[0];
            int v2 = res[1];
            switch (direction){
                case 'U':
                    upCount++;
                    break;
                case 'L':
                    leftCount++;
                    break;
                case 'D':
                    downCount++;
                    break;
                case 'R':
                    rightCount++;
                    break;
            }
        }
        System.out.println("left "+leftCount);
        System.out.println("right "+rightCount);
        System.out.println("up "+upCount);
        System.out.println("down "+downCount);
        res[0] = rightCount-leftCount;
        res[1] = upCount - downCount ;
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static boolean isEqual(Integer[] a, Integer[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean pass() {
        boolean res = true;

        {
            String test = "UUU";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{0, 3});
        }

        {
            String test = "ULDR";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{0, 0});
        }

        {
            String test = "ULLLDUDUURLRLR";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{-2, 2});
        }

        {
            String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[]{1, 1});
        }

        return res;
    }

    public static void main(String[] args) {
        if(pass()){
            System.out.println("{Pass");
        } else {
            System.out.println("Test failures");
        }
    }
}
