package euler;

import static java.lang.Math.sqrt;

public class PythagoreanTriplet {
    public static int productForSum(int sum){
        for (int a = 1; a <= sum; a++) {
            for (int b = a + 1; b <= sum; b++) {
                double c = sqrt(a * a + b * b);
                if (a + b + c == sum){
                    return a * b * (int)c;
                }
            }
        }
        return 0;
    }
}
