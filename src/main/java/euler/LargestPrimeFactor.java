package euler;

public class LargestPrimeFactor {
    public static long forNumber(long number) {
        long dividend = number;
        long divisor = 2;
        long largestPrime = divisor;

        while (divisor <= dividend){
            if (dividend % divisor == 0){
                dividend /= divisor;
                largestPrime = divisor;
            }
            divisor = inc(divisor);
        }
        return largestPrime;
    }

    private static long inc(long divisor){
        long increment = divisor == 2 ? 1 : 2;
        return divisor + increment;
    }
}
