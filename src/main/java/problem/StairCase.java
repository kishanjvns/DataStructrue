package problem;

public class StairCase {
    public static Integer countSteps(Integer n) {
        //child can may climb either 1 or 2 or 3 steps at a time
        //need to calculate the total count of permutation to reach at the top
        return contStepsHelper(n,0);
    }
    public static int contStepsHelper(int n,int total){
        if(n == 0){
            return 1;
        }if(n < 0){
            return 0;
        }
        total=contStepsHelper(n-1,total)+contStepsHelper(n-2,total)+contStepsHelper(n-3,total);
        return total;
    }


    public static boolean doTestsPass()
    {
        return countSteps(3) == 4
                && countSteps(4) == 7;
    }

    public static void main(String[] args)
    {
        System.out.println(countSteps(3));
        /*if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }

        for (Integer n = 1; n <= 5; n++)
        {
            Integer numberOfCombinations = countSteps(n);
            System.out.println(n + " steps => " + numberOfCombinations);
        }*/
    }
}
