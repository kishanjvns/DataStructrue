package problem;

public class SquareRoot {
    private static double squareRoot(double number) {
        for (int i = 1; i < number; ++i) {
            int square = i * i;
            if (square == number) {
                // perfect square
                return i;
            }
            //not a perfect square
            if (square > number) {
                // found left part of decimal
                return sqrt(number, i - 1, i,6);
            }
        }
        return Double.NaN;
    }


    private static double sqrt(double number, double low, double high,int PRECISION) {
        double mid = (low + high) / 2;
        double square = mid * mid;
        if (square == number || (Math.abs(number - square) < PRECISION)) {
            return mid;
        }
        if (square < number) {
            return sqrt(number, mid, high,PRECISION);
        }
        return sqrt(number, low, mid,PRECISION);
    }



    public static void main( String args[])
    {
        double[] inputs = {2, 4, 100};
        double[] expected_values = {1.41421, 2, 10 };
        double threshold = 0.001;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
            }
        }
        System.out.println( "All tests passed");
    }
}
