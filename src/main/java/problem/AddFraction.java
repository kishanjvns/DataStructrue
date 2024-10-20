package problem;

public class AddFraction {
    /**
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     */
    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        int den1 = fraction1[1];
        int den2 = fraction2[1];
        double mult = den1 * den2;
        double d1 = mult / den1;
        double d2 = mult / den2;
        double max =d1 > d2 ? d1: d2;
        double lcm =(max % d1 ==0 && max % d2 ==0) ? max:mult;
        int num1 = fraction1[0] * fraction2[1];
        int num2 = fraction2[0] * fraction1[1];
        int res1 =(int) num1 + num2;
        return (new int[]{res1, (int) lcm});
    }


    public static void main(String[] args) {
        int[] result = addFractions(new int[]{2, 3}, new int[]{1, 2});

        if (result[0] == 7 && result[1] == 6) {
            System.out.println("Test passed.");
            return;
        } else {
            System.out.println("Test failed.");
            return;
        }
    }
}
