package euler;

import static java.lang.Math.sqrt;

public class LargestPrimeFactor {
    public static long forNumber(long number) {
        long dividend = number;
        long divisor = 2;
        long largestPrime = divisor;

        if (dividend % divisor == 0){
            dividend /= divisor;
            largestPrime = divisor;
        }
        divisor++;

        while (divisor <= sqrt(number)){
            if (dividend % divisor == 0){
                dividend /= divisor;
                largestPrime = divisor;
            }
            divisor+=2;
        }
        return largestPrime;
    }
}
