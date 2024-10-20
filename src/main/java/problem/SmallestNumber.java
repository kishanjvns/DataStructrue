package problem;

public class SmallestNumber {
    public static int FindMin(int a[]) {
        if (a == null)
            throw new IllegalArgumentException("Invalid input");

        int min = Integer.MAX_VALUE;
        for(int num: a){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    public static int FindMinIndex(int a[]) {
        if (a == null){
            throw new IllegalArgumentException("Invalid input");
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i < a.length; i++){
            if(a[i] < min){
                min = a[i];
                minIndex =i;
            }
        }
        int nRotatedTime = (a.length-minIndex);
        System.out.println("how much it is rotated "+nRotatedTime);
        System.out.println(((a.length-nRotatedTime) - minIndex));
        return  min;
    }
    public static void testFindMin(){
        boolean result = true;
        result = result && FindMin(new int[] { 3, 4, 5, 6, 1, 2 }) == 1;
        result = result && FindMin(new int[] { 2, 1 }) == 1;
        result = result && FindMin(new int[] { 1 }) == 1;

        try {
            FindMin(null);
            result = false;
        } catch (Exception e) {
            result = result && true;
        }

        if (result) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
    public static void testFindMinIndex(){
        boolean result = true;
        result = result && FindMinIndex(new int[] { 5,1,2,3,4 }) == 0;
        result = result && FindMinIndex(new int[] { 2, 1 }) == 0;
        result = result && FindMinIndex(new int[] { 1 }) == 0;

        try {
            FindMin(null);
            result = false;
        } catch (Exception e) {
            result = result && true;
        }

        if (result) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }

    public static void main(String args[]) {
        //testFindMin();
        testFindMinIndex();
    }
}
